package com.purrfectmatch.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ShelterAccountNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(ShelterAccountNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String shelterAccountNotFoundHandler(ShelterAccountNotFoundException ex) {
    return ex.getMessage();
  }
}