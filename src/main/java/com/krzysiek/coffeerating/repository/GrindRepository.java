package com.krzysiek.coffeerating.repository;

import com.krzysiek.coffeerating.model.Grind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrindRepository extends JpaRepository<Grind, Long> {
}
