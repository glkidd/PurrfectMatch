package com.purrfectmatch.restservice;

import org.springframework.data.jpa.repository.JpaRepository;

interface DogRepository extends JpaRepository<Dog, Long> {

}