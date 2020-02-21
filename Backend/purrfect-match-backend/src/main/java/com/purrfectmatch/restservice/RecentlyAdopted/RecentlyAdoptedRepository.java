package com.purrfectmatch.restservice;

import org.springframework.data.jpa.repository.JpaRepository;

interface RecentlyAdoptedRepository extends JpaRepository<RecentlyAdopted, Long> {

}