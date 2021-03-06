package com.suwajk.coffeerating.repository;

import com.suwajk.coffeerating.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    Coffee findByBrandAndName(String brand, String name);
}
