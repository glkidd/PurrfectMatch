package com.purrfectmatch.restservice.Breeds;

import com.purrfectmatch.restservice.NegativePageNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BreedController {
  @Autowired
  BreedService service;

  private final BreedRepository repository;
  private Integer pageSize;

  public BreedController(BreedRepository repository) {
    this.repository = repository;
    this.pageSize = 10;
  }

  @PostMapping("/breeds/all")
  List<Breed> all(@RequestParam(defaultValue = "0") Integer pageNumber) {
    if (pageNumber < 0) {
      throw new NegativePageNumberException(pageNumber);
    }

    return service.getAllBreeds(pageNumber, pageSize);
  }

  @PostMapping("/breeds/get/{id}")
  Breed get(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new BreedNotFoundException(id));
  }
}