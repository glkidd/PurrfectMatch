package com.purrfectmatch.restservice;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class RecentlyAdoptedService {
  @Autowired
  RecentlyAdoptedRepository repository;

  public List<RecentlyAdopted> getAllRecentlyAdopted(Integer pageNumber, Integer pageSize, String sortBy) {
    Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));

    Page<RecentlyAdopted> pagedResult = repository.findAll(paging);

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return new ArrayList<RecentlyAdopted>();
    }
  }
}