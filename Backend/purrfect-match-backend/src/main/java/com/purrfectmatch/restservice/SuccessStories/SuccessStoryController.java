package com.purrfectmatch.restservice;

import java.util.List;

import com.purrfectmatch.restservice.SuccessStoryService;
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
class SuccessStoryController {
  @Autowired
  SuccessStoryService service;

  private final SuccessStoryRepository repository;
  private Integer pageSize;

  SuccessStoryController(SuccessStoryRepository repository) {
    this.repository = repository;
  }

  // Aggregate root

  @PostMapping("/success_stories/all")
  List<SuccessStory> all(@RequestParam(defaultValue = "0") Integer pageNumber) {
    try {
      if (pageNumber < 0) {
        throw new NegativePageNumberException(pageNumber);
      }
    } catch (Exception e) {
      System.out.println("Exiting program...");
      System.exit(1);
    }

    return service.getAllSuccessStories(pageNumber, pageSize);
  }

  @PostMapping("/success_stories/new")
  SuccessStory newSuccessStory(@RequestBody SuccessStory newSuccessStory) {
    return repository.save(newSuccessStory);
  }

  // Single item

  @PostMapping("/success_stories/get/{id}")
  SuccessStory get(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new SuccessStoryNotFoundException(id));
  }
}
