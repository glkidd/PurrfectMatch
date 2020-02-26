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

  OtherAnimalController(OtherAnimalRepository repository) {
    this.repository = repository;
  }

  @PostMapping("/otheranimal/all")
  List<OtherAnimal> all(@RequestParam(defaultValue = "0") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
    return service.getAllOtherAnimals(pageNumber, pageSize, sortBy);
  }

  // TODO: Stub method.
  @PostMapping("/otheranimal/new")
  OtherAnimal newRecentlyAdoptedPet(@RequestBody OtherAnimal newOtherAnimal) {
    return repository.save(newOtherAnimal);
  }

  @PostMapping("/otheranimal/get/{id}")
  OtherAnimal get(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new OtherAnimalNotFoundException(id));
  }

  @PostMapping("/otheranimal/delete/{id}")
  void deleteOtherAnimal(@PathVariable Long id) {
    repository.deleteById(id);
  }
}