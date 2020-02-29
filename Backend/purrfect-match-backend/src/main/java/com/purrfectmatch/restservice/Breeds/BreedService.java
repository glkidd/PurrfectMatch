package com.purrfectmatch.restservice.Breeds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BreedService {
  @Autowired
  BreedRepository repository;

  public List<Breed> getAllBreeds(Integer pageNumber, Integer pageSize) {
    Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by("id"));

    Page<Breed> pagedResult = repository.findAll(paging);

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return new ArrayList<Breed>();
    }
  }
}