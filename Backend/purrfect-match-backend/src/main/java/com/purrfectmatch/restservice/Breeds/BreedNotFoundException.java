package com.purrfectmatch.restservice;

public class BreedNotFoundException extends RuntimeException {
  BreedNotFoundException(Long id) {
    super("Could not find breed " + id);
  }
}