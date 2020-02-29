package com.purrfectmatch.restservice.Breeds;

import java.util.List;

import com.purrfectmatch.restservice.NegativePageNumberException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

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

  @GetMapping("/breeds/all")
  List<Breed> all(@RequestParam(defaultValue = "0") Integer pageNumber) {
    try {
      if (pageNumber < 0) {
        throw new NegativePageNumberException(pageNumber);
      }
    } catch (Exception e) {
      System.out.println("Exiting program...");
      System.exit(1);
    }

    return service.getAllBreeds(pageNumber, pageSize);
  }

  @PostMapping("/breeds/get/{id}")
  Breed get(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new BreedNotFoundException(id));
  }
}