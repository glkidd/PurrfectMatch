package com.purrfectmatch.restservice.ShelterAccounts;

import com.purrfectmatch.restservice.ValidationException;

import java.security.SecureRandom;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;

public class ShelterAuth {
    // Size of salt possibility space, in bytes. Actual salt will be slightly larger due to being base 64 encoded.
    public static final int SALT_SIZE = 16;
    // Size of auth token, in bytes. Actual will be slightly larger due to b64 encode
    public static final int AUTH_TOKEN_SIZE = 128;
    // How many iterations of the hashing algorithm to run. Bigger = more secure but slower.  
    public static final int HASH_ITERATIONS = 1 << 16;
    // How many bytes the final hash is. 
    public static final int HASH_SIZE = 256;
    // How many seconds an auth token is valid for.
    public static final int AUTH_TOKEN_LIFETIME = 60 * 60;
    
    private static SecureRandom rng = new SecureRandom();
    
    // Password is a char[] as strings are immutable. This lets us zero it once we're finished with it to keep it from staying
    // in memory until the garbage collector runs. 
    // WARNING: calling this function destroys the data in password
    public static ShelterAccount createAccount(String email, char[] password, String name, String city, String street,
            String state, int zip, String phone, String website) {
        // Generate and encode a random salt. 
        byte[] salt = new byte[SALT_SIZE];
        rng.nextBytes(salt);
        String strSalt = Base64.getEncoder().encodeToString(salt);

        String pwdHash = hash(password, strSalt);
        // At this point, there is no longer a need to store the password. 
        Arrays.fill(password, '\0');
        
        // Create object. It will still need to be added to the database. 
        return new ShelterAccount(email, pwdHash, strSalt, name, city, street, state, zip, phone, website);
    }
    
    public static void verifyAuthTokenOrThrow(ShelterAccount account, String token) throws ValidationException {
        if (token.equals(account.getAuthToken())) {
            if (Instant.now().getEpochSecond() > account.getAuthIssued() + AUTH_TOKEN_LIFETIME) {
                return;
            } else {
                throw new ValidationException("Auth token timed out");
            }
        } else {
            throw new ValidationException("Invalid auth token");
        }
    }
    
    // WARNING: this function destroys the data in password
    public static String generateAuthToken(ShelterAccount account, char[] password) throws ValidationException {
        String salt = account.getPasswordSalt();
        
        String pwdHash = hash(password, salt);
        // At this point, there is no longer a need to store the password. 
        Arrays.fill(password, '\0');
        
        if (pwdHash.equals(account.getPasswordHash())) {
            // Return a random auth token
            byte[] token = new byte[AUTH_TOKEN_SIZE];
            rng.nextBytes(token);
            return Base64.getEncoder().encodeToString(token);
        } else {
            throw new ValidationException("Password hashes did not match");
        }
    }
    
    private static String hash(char[] pwd, String salt) throws ValidationException {
        try {
            SecretKeyFactory hasher = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            SecretKey hashValue = hasher.generateSecret(new PBEKeySpec(pwd, salt.getBytes(), HASH_ITERATIONS, HASH_SIZE));
            return Base64.getEncoder().encodeToString(hashValue.getEncoded());
        } catch (Exception e) {
            throw new ValidationException("Failed to hash password");
        }
    }
}