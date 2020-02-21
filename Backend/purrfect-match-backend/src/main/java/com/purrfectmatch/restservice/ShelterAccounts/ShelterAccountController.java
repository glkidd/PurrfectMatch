package com.purrfectmatch.restservice;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")
class ShelterAccountController {

  private final ShelterAccountRepository repository;

  ShelterAccountController(ShelterAccountRepository repository) {
    this.repository = repository;
  }

  // TODO: Stub method.
  @PostMapping("/shelter_accounts/new")
  ShelterAccount newShelterAccount(@RequestBody ShelterAccount newShelterAccount) {
    return repository.save(newShelterAccount);
  }

  @PostMapping("/shelter_accounts/get/{id}")
  ShelterAccount get(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new ShelterAccountNotFoundException(id));
  }

  // This is a temporary method. It is incomplete. It is a dummy method.
  @PostMapping("/shelter_accounts/replace/{id}")
  ShelterAccount replaceShelterAccount(@RequestBody ShelterAccount newShelterAccount, @PathVariable Long id) {
    return repository.findById(id).map(shelterAccount -> {
      shelterAccount.setEmail(newShelterAccount.getEmail());
      return repository.save(shelterAccount);
    }).orElseGet(() -> {
      newShelterAccount.setId(id);
      return repository.save(newShelterAccount);
    });
  }

  @PostMapping("/shelter_accounts/delete/{id}")
  void deleteShelterAccount(@PathVariable Long id) {
    repository.deleteById(id);
  }
}