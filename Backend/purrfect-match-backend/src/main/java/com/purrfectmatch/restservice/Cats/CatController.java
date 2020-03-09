package com.purrfectmatch.restservice.Cats;

import com.purrfectmatch.restservice.NegativePageNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CatController {
  @Autowired
  CatService service;

  private final CatRepository repository;
  private Integer pageSize;

  public CatController(CatRepository repository) {
    this.repository = repository;
    this.pageSize = 10;
  }

  @PostMapping("/cats/all")
  List<Cat> all(@RequestParam(defaultValue = "0") Integer pageNumber) {
    if (pageNumber < 0) {
      throw new NegativePageNumberException(pageNumber);
    }

    return service.getAllCats(pageNumber, pageSize);
  }

  @PostMapping("/cats/get/{id}")
  Cat get(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new CatNotFoundException(id));
  }
}