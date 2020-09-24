package com.krzysiek.coffeerating.repository;

import com.krzysiek.coffeerating.model.CoffeeMachineRecipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeMachineRecipeRepository extends JpaRepository<CoffeeMachineRecipe, Long> {
}
