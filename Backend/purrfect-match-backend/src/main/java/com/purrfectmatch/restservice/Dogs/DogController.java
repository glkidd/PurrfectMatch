package com.purrfectmatch.restservice.Dogs;

import com.purrfectmatch.restservice.NegativePageNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DogController {
  @Autowired
  DogService service;

  private final DogRepository repository;
  private Integer pageSize;

  public DogController(DogRepository repository) {
    this.repository = repository;
    this.pageSize = 10;
  }

  @PostMapping("/dogs/all")
  List<Dog> all(@RequestParam(defaultValue = "0") Integer pageNumber) {
    if (pageNumber < 0) {
      throw new NegativePageNumberException(pageNumber);
    }

    return service.getAllDogs(pageNumber, pageSize);
  }

  @PostMapping("/dogs/get/{id}")
  Dog get(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new DogNotFoundException(id));
  }
}