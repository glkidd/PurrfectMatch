package com.purrfectmatch.restservice.Dogs;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {

}