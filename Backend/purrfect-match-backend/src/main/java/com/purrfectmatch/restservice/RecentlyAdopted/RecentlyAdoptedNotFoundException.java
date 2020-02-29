package com.purrfectmatch.restservice.RecentlyAdopted;

public class RecentlyAdoptedNotFoundException extends RuntimeException {

  public RecentlyAdoptedNotFoundException(Long id) {
    super("Could not find recently adopted " + id);
  }
}