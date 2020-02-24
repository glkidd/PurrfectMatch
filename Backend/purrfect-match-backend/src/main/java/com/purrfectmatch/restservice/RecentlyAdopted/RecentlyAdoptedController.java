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
class RecentlyAdoptedController {
  @Autowired
  RecentlyAdoptedService service;

  private final RecentlyAdoptedRepository repository;

  RecentlyAdoptedController(RecentlyAdoptedRepository repository) {
    this.repository = repository;
  }

  @PostMapping("/recently_adopted/all")
  List<RecentlyAdopted> all(@RequestParam(defaultValue = "0") Integer pageNumber,
      @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
    return service.getAllRecentlyAdopted(pageNumber, pageSize, sortBy);
  }

  // TODO: Stub method.
  @PostMapping("/recently_adopted/new")
  RecentlyAdopted newRecentlyAdoptedPet(@RequestBody RecentlyAdopted newRecentlyAdopted) {
    return repository.save(newRecentlyAdopted);
  }

  @PostMapping("/recently_adopted/get/{id}")
  RecentlyAdopted get(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new RecentlyAdoptedNotFoundException(id));
  }

  @PostMapping("/recently_adopted/delete/{id}")
  void deleteRecentlyAdopted(@PathVariable Long id) {
    repository.deleteById(id);
  }
}