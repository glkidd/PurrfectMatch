package com.purrfectmatch.restservice.ShelterAccounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Service
public class ShelterAccountService {
    @Autowired
    private ShelterAccountRepository repository;
    
    @Autowired
    private EntityManager entityManager;
    
    public ShelterAccount getAccountFromEmail(String email) {
        Query query = entityManager.createQuery("SELECT u FROM shelter_accounts WHERE u.email=:email");
        query.setParameter("email", email);
        
        return (ShelterAccount) query.getSingleResult();
    }
    
    public void updateAccountAuth(ShelterAccount account, String token, long time) {
        account.setAuthToken(token);
        account.setAuthIssued(time);
        
        repository.saveAndFlush(account);
    }

}