//package com.purrfectmatch.restservice;
package com.purrfectmatch.restservice.SendEmail;

class ContactPageNotFoundException extends RuntimeException {

  ContactPageNotFoundException() {
    super("Could not email ");
  }
}