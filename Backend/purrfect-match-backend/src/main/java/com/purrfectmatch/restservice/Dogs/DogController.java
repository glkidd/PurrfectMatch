package com.purrfectmatch.restservice.Dogs;

import java.util.List;
import com.purrfectmatch.restservice.NegativePageNumberException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

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
    try {
      if (pageNumber < 0) {
        throw new NegativePageNumberException(pageNumber);
      }
    } catch (Exception e) {
      System.out.println("Exiting program...");
      System.exit(1);
    }

    return service.getAllDogs(pageNumber, pageSize);
  }

  @PostMapping("/dogs/get/{id}")
  Dog get(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new DogNotFoundException(id));
  }

  @PostMapping("/dogs/delete/{id}")
  void deleteDog(@PathVariable Long id) {
    repository.deleteById(id);
  }
}