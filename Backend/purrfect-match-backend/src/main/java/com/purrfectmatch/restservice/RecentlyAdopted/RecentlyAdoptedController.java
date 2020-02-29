package com.purrfectmatch.restservice.RecentlyAdopted;

import com.purrfectmatch.restservice.NegativePageNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RecentlyAdoptedController {
  @Autowired
  RecentlyAdoptedService service;

  private final RecentlyAdoptedRepository repository;
  private Integer pageSize;

  public RecentlyAdoptedController(RecentlyAdoptedRepository repository) {
    this.repository = repository;
    this.pageSize = 10;
  }

  @PostMapping("/recently_adopted/all")
  List<RecentlyAdopted> all(@RequestParam(defaultValue = "0") Integer pageNumber) {
    try {
      if (pageNumber < 0) {
        throw new NegativePageNumberException(pageNumber);
      }
    } catch (Exception e) {
      System.out.println("Exiting program...");
      System.exit(1);
    }

    return service.getAllRecentlyAdopted(pageNumber, pageSize);
  }

  @PostMapping("/recently_adopted/get/{id}")
  RecentlyAdopted get(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new RecentlyAdoptedNotFoundException(id));
  }
}