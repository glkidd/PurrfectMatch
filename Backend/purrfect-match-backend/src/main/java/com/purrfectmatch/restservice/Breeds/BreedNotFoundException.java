package com.purrfectmatch.restservice.Breeds;

public class BreedNotFoundException extends RuntimeException {
  public BreedNotFoundException(Long id) {
    super("Could not find breed " + id);
  }
}