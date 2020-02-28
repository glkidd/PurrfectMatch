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
class OtherAnimalController {
  @Autowired
  OtherAnimalService service;

  private final OtherAnimalRepository repository;
  private Integer pageSize;

  OtherAnimalController(OtherAnimalRepository repository) {
    this.repository = repository;
    this.pageSize = 10;
  }

  @PostMapping("/other_animal/all")
  List<OtherAnimal> all(@RequestParam(defaultValue = "0") Integer pageNumber) {
    try {
      if (pageNumber < 0) {
        throw new NegativePageNumberException(pageNumber);
      }
    } catch (Exception e) {
      System.out.println("Exiting program...");
      System.exit(1);
    }

    return service.getAllOtherAnimals(pageNumber, pageSize);
  }

  @PostMapping("/other_animal/get/{id}")
  OtherAnimal get(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new OtherAnimalNotFoundException(id));
  }

  @PostMapping("/other_animal/delete/{id}")
  void deleteOtherAnimal(@PathVariable Long id) {
    repository.deleteById(id);
  }
}