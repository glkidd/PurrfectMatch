package com.purrfectmatch.restservice;

public class NegativePageNumberException extends RuntimeException {
  public NegativePageNumberException(Integer pageNumber) {
    super("Negative page number was " + pageNumber);
  }
}