package com.purrfectmatch.restservice;

public class DogNotFoundException extends RuntimeException {
  DogNotFoundException(Long id) {
    super("Could not find dog " + id);
  }
}