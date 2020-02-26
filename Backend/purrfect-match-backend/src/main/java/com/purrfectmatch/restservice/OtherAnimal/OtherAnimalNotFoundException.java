package com.purrfectmatch.restservice;

public class OtherAnimalNotFoundException extends RuntimeException {
   OtherAnimalNotFoundException(Long id) {
    super("Could not find other animal " + id);
  }
}