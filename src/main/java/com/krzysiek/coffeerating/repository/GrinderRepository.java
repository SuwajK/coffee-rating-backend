package com.krzysiek.coffeerating.repository;

import com.krzysiek.coffeerating.model.Grinder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrinderRepository extends JpaRepository<Grinder, Long> {
}
