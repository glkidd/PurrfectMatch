package com.purrfectmatch.restservice;

import org.springframework.data.jpa.repository.JpaRepository;

interface OtherAnimalRepository extends JpaRepository<OtherAnimal, Long> {

}