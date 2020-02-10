//package com.purrfectmatch.restservice;
package com.purrfectmatch.restservice.SendEmail;

import java.util.List;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ContactPageController {

  private final ContactPage repository;

  ContactPageController(ContactPage repository) {
    this.repository = repository;
  }

  // Aggregate root

  /*

  @GetMapping("/contactpage")
  List<ContactPage> all() {
    return repository.findAll();
  }

  @PostMapping("/contactpage")
  Employee newContactPage(@RequestBody Employee newContactPage) {
    return repository.save(newContactPage);
  }
  */
}