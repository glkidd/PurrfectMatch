package com.purrfectmatch.restservice.RecentlyAdopted;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RecentlyAdoptedNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(RecentlyAdoptedNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String recentlyAdoptedNotFoundHandler(RecentlyAdoptedNotFoundException ex) {
    return ex.getMessage();
  }
}