package com.purrfectmatch.restservice.SuccessStories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuccessStoryService {
  @Autowired
  SuccessStoryRepository repository;

  public List<SuccessStory> getAllSuccessStories(Integer pageNumber, Integer pageSize) {
    Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by("id"));

    Page<SuccessStory> pagedResult = repository.findAll(paging);

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return new ArrayList<SuccessStory>();
    }
  }
}