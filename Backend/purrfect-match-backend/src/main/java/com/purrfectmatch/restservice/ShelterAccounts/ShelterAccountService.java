package com.purrfectmatch.restservice;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ShelterAccountService {
  @Autowired
  ShelterAccountRepository repository;

  public List<ShelterAccount> getAllShelterAccounts(Integer pageNumber, Integer pageSize, String sortBy) {
    Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));

    Page<ShelterAccount> pagedResult = repository.findAll(paging);

    if (pagedResult.hasContent()) {
      return pagedResult.getContent();
    } else {
      return new ArrayList<ShelterAccount>();
    }
  }
}