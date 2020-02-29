package com.purrfectmatch.restservice.SuccessStories;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SuccessStoryNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(SuccessStoryNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String successStoryNotFoundHandler(SuccessStoryNotFoundException ex) {
    return ex.getMessage();
  }
}