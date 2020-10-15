package com.suwajk.coffeerating.repository;

import com.suwajk.coffeerating.model.Grind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrindRepository extends JpaRepository<Grind, Long> {
}
