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
  private final RecentlyAdoptedRepository repository;
  private Integer pageSize;

  RecentlyAdoptedController(RecentlyAdoptedRepository repository) {
    this.repository = repository;
    this.pageSize = 10;
  }

  @PostMapping("/recently_adopted/all")
  List<RecentlyAdopted> all(@RequestParam(defaultValue = "0") Integer pageNumber) {
    return service.getAllRecentlyAdopted(pageNumber, pageSize);
  }

  @PostMapping("/recently_adopted/get/{id}")
  RecentlyAdopted get(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new RecentlyAdoptedNotFoundException(id));
  }
}