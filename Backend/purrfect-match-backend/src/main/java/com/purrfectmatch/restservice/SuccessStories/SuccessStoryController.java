package com.purrfectmatch.restservice.SuccessStories;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class SuccessStoryController {

  private final SuccessStoryRepository repository;

  SuccessStoryController(SuccessStoryRepository repository) {
    this.repository = repository;
  }

  // Aggregate root

  @GetMapping("/success_stories")
  List<SuccessStory> all() {
    return repository.findAll();
  }

  @PostMapping("/success_stories")
  SuccessStory newSuccessStory(@RequestBody SuccessStory newSuccessStory) {
    return repository.save(newSuccessStory);
  }

  // Single item

  @GetMapping("/success_stories/{id}")
  SuccessStory one(@PathVariable Long id) {

    return repository.findById(id).orElseThrow(() -> new SuccessStoryNotFoundException(id));
  }

  @PutMapping("/success_stories/{id}")
  SuccessStory replaceSuccessStory(@RequestBody SuccessStory newSuccessStory, @PathVariable Long id) {

    return repository.findById(id).map(successStory -> {
      successStory.setAge(newSuccessStory.getAge());
      successStory.setGender(newSuccessStory.getGender());
      return repository.save(successStory);
    }).orElseGet(() -> {
      newSuccessStory.setId(id);
      return repository.save(newSuccessStory);
    });
  }

  @DeleteMapping("/success_stories/{id}")
  void deleteSuccessStory(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
