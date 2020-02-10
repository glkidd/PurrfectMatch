//package com.purrfectmatch.restservice;
package com.purrfectmatch.restservice.SendEmail;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ContactPageNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(ContactPageNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String contactPageNotFoundHandler(ContactPageNotFoundException ex) {
    return ex.getMessage();
  }
}