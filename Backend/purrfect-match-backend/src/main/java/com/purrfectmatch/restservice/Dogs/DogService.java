package com.purrfectmatch.restservice;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DogService {
  @Autowired
  DogRepository repository;

  public List<Dog> getAllDogs(Integer pageNumber, Integer pageSize, String sortBy) {
    Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));

    Page<Dog> pagedResult = repository.findAll(paging);

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return new ArrayList<Dog>();
    }
  }
}