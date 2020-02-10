package com.purrfectmatch.restservice.SuccessStories;

class SuccessStoryNotFoundException extends RuntimeException {

  SuccessStoryNotFoundException(Long id) {
    super("Could not find success story " + id);
  }
}