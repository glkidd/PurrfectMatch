package com.purrfectmatch.restservice.Breeds;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BreedNotFoundAdvice {
  @ResponseBody
  @ExceptionHandler(BreedNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String breedNotFoundHandler(BreedNotFoundException ex) {
    return ex.getMessage();
  }
}