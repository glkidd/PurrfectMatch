package com.purrfectmatch.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NegativePageNumberAdvice {
  @ResponseBody
  @ExceptionHandler(NegativePageNumberException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String negativePageNumberHandler(NegativePageNumberException ex) {
    return ex.getMessage();
  }
}