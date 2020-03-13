package com.purrfectmatch.restservice.SuccessStories;

public class SuccessStoryNotFoundException extends RuntimeException {

  public SuccessStoryNotFoundException(Long id) {
    super("Could not find success story " + id);
  }
}