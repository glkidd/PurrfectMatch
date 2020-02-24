package com.purrfectmatch.restservice;

class BreedNotFoundException extends RuntimeException {
  BreedNotFoundException(Long id) {
    super("Could not find breed " + id);
  }
}