package com.purrfectmatch.restservice;

public class CatNotFoundException extends RuntimeException {
  CatNotFoundException(Long id) {
    super("Could not find cat " + id);
  }
}