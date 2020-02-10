package com.purrfectmatch.restservice;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ShelterAccountController {

  private final ShelterAccountRepository repository;

  ShelterAccountController(ShelterAccountRepository repository) {
    this.repository = repository;
  }

  // Aggregate root

  @GetMapping("/shelter_accounts")
  List<ShelterAccount> all() {
    return repository.findAll();
  }

  @PostMapping("/shelter_accounts")
  ShelterAccount newShelterAccount(@RequestBody ShelterAccount newShelterAccount) {
    return repository.save(newShelterAccount);
  }

  // Single item

  @GetMapping("/shelter_accounts/{id}")
  ShelterAccount one(@PathVariable Long id) {

    return repository.findById(id).orElseThrow(() -> new ShelterAccountNotFoundException(id));
  }

  @PutMapping("/shelter_accounts/{id}")
  ShelterAccount replaceShelterAccount(@RequestBody ShelterAccount newShelterAccount, @PathVariable Long id) {
    return repository.findById(id).map(shelterAccount -> {
      shelterAccount.setEmail(newShelterAccount.getEmail());
      return repository.save(shelterAccount);
    }).orElseGet(() -> {
      newShelterAccount.setId(id);
      return repository.save(newShelterAccount);
    });
  }

  @DeleteMapping("/shelter_accounts/{id}")
  void deleteShelterAccount(@PathVariable Long id) {
    repository.deleteById(id);
  }
}