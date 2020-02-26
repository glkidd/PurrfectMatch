package com.purrfectmatch.restservice;

import java.util.List;
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
class DogController {
  @Autowired
  DogService service;

  private final DogRepository repository;

  DogController(DogRepository repository) {
    this.repository = repository;
  }

  @PostMapping("/dog/all")
  List<Dog> all(@RequestParam(defaultValue = "0") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
    return service.getAllDogs(pageNumber, pageSize, sortBy);
  }

  // TODO: Stub method.
  @PostMapping("/dog/new")
  Dog newRecentlyAdoptedPet(@RequestBody Dog newDog) {
    return repository.save(newDog);
  }

  @PostMapping("/dog/get/{id}")
  Dog get(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new DogNotFoundException(id));
  }

  @PostMapping("/dog/delete/{id}")
  void deleteDog(@PathVariable Long id) {
    repository.deleteById(id);
  }
}