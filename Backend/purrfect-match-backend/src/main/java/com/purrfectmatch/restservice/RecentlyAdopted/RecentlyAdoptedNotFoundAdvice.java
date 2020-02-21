package com.purrfectmatch.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class RecentlyAdoptedNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(RecentlyAdoptedNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String recentlyAdoptedNotFoundHandler(RecentlyAdoptedNotFoundException ex) {
    return ex.getMessage();
  }
}