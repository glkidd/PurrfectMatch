package com.purrfectmatch.restservice.SuccessStories;

import com.purrfectmatch.restservice.NegativePageNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class SuccessStoryController {
  @Autowired
  SuccessStoryService service;

  private final SuccessStoryRepository repository;
  private Integer pageSize;

  public SuccessStoryController(SuccessStoryRepository repository) {
    this.repository = repository;
    this.pageSize = 10;
  }

  // Aggregate root

  @PostMapping("/success_stories/all")
  List<SuccessStory> all(@RequestParam(defaultValue = "0") Integer pageNumber) {
    if (pageNumber < 0) {
      throw new NegativePageNumberException(pageNumber);
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
