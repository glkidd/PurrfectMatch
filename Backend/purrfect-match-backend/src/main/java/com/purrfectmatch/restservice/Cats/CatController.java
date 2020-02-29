package com.purrfectmatch.restservice.Cats;

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
    try {
      if (pageNumber < 0) {
        throw new NegativePageNumberException(pageNumber);
      }
    } catch (Exception e) {
      System.out.println("Exiting program...");
      System.exit(1);
    }

    return service.getAllCats(pageNumber, pageSize);
  }

  @PostMapping("/cats/get/{id}")
  Cat get(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new CatNotFoundException(id));
  }
}