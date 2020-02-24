package com.purrfectmatch.restservice;

import org.springframework.data.jpa.repository.JpaRepository;

interface BreedRepository extends JpaRepository<Breed, Long> {

}