package com.purrfectmatch.restservice;

class RecentlyAdoptedNotFoundException extends RuntimeException {

  RecentlyAdoptedNotFoundException(Long id) {
    super("Could not find recently adopted " + id);
  }
}