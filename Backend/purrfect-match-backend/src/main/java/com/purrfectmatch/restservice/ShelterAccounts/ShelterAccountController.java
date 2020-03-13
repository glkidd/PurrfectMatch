package com.purrfectmatch.restservice.ShelterAccounts;

import com.purrfectmatch.restservice.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.time.Instant;

@RestController
@CrossOrigin(origins = "*")
public class ShelterAccountController {
    @Autowired
    ShelterAccountService service;

    private final ShelterAccountRepository repository;
    final int PAGE_SIZE = 10;

    public ShelterAccountController(ShelterAccountRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/shelter/login")
    ResponseEntity login(@RequestParam String email, @RequestParam char[] password) {
        try {
            ShelterAccount account = service.getAccountFromEmail(email);
            
            String authToken = ShelterAuth.generateAuthToken(account, password);
            long now = Instant.now().getEpochSecond();
            
            service.updateAccountAuth(account, authToken, now);
            
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(authToken); 
        } catch (Exception e) { 
            // We use this to turn any possible exception into a single one
            // to avoid potentially leaking information. 
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Incorrect username or password");
        }
    }

}
