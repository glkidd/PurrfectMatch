package com.purrfectmatch.restservice;

import org.springframework.data.jpa.repository.JpaRepository;

interface CatRepository extends JpaRepository<Cat, Long> {

}