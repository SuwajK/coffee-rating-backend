package com.suwajk.coffeerating.repository;

import com.suwajk.coffeerating.model.BrewMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrewMethodRepository extends JpaRepository<BrewMethod, Long> {
}
