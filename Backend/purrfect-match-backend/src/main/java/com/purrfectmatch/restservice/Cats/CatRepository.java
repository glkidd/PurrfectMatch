package com.purrfectmatch.restservice.Cats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CatRepository extends JpaRepository<Cat, Long>, JpaSpecificationExecutor  {

}