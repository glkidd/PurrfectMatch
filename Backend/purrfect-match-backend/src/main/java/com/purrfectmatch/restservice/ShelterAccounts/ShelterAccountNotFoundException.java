package com.purrfectmatch.restservice.ShelterAccounts;

public class ShelterAccountNotFoundException extends RuntimeException {

  public ShelterAccountNotFoundException(Long id) {
    super("Could not find shelter account " + id);
  }
}