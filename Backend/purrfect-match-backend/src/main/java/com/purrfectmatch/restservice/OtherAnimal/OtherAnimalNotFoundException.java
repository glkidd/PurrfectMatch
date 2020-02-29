package com.purrfectmatch.restservice.OtherAnimal;

public class OtherAnimalNotFoundException extends RuntimeException {
   public OtherAnimalNotFoundException(Long id) {
    super("Could not find other animal " + id);
  }
}