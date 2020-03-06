package com.purrfectmatch.restservice.OtherAnimal;

import com.purrfectmatch.restservice.NegativePageNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OtherAnimalController {
  @Autowired
  OtherAnimalService service;

  private final OtherAnimalRepository repository;
  private Integer pageSize;

  public OtherAnimalController(OtherAnimalRepository repository) {
    this.repository = repository;
    this.pageSize = 10;
  }

  @PostMapping("/other_animal/all")
  List<OtherAnimal> all(@RequestParam(defaultValue = "0") Integer pageNumber) {
    if (pageNumber < 0) {
      throw new NegativePageNumberException(pageNumber);
    }

    return service.getAllOtherAnimals(pageNumber, pageSize);
  }

  @PostMapping("/other_animal/get/{id}")
  OtherAnimal get(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new OtherAnimalNotFoundException(id));
  }
}