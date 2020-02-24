package com.purrfectmatch.restservice;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")
class ShelterAccountController {
  @Autowired
  ShelterAccountService service;

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

  @PostMapping("/shelter_accounts/delete/{id}")
  void deleteShelterAccount(@PathVariable Long id) {
    repository.deleteById(id);
  }
}