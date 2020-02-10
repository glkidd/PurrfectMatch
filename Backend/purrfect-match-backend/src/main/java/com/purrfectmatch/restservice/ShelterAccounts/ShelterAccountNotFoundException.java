package com.purrfectmatch.restservice;

class ShelterAccountNotFoundException extends RuntimeException {

  ShelterAccountNotFoundException(Long id) {
    super("Could not find shelter account " + id);
  }
}