package com.krzysiek.coffeerating.service;

import com.krzysiek.coffeerating.model.CoffeeMachineRecipe;
import com.krzysiek.coffeerating.repository.CoffeeMachineRecipeRepository;
import com.krzysiek.coffeerating.repository.CoffeeMachineRepository;
import com.krzysiek.coffeerating.repository.GrindRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoffeeRecipeService {

    private final CoffeeMachineRecipeRepository coffeeMachineRecipeRepository;
    private final CoffeeMachineRepository coffeeMachineRepository;
    private final GrindRepository grindRepository;

    public List<CoffeeMachineRecipe> getCoffeeMachineRecipes() {
        return coffeeMachineRecipeRepository.findAll();
    }

    public CoffeeMachineRecipe getCoffeeMachineRecipeById(Long id) {
        return coffeeMachineRecipeRepository.findById(id).orElseThrow();
    }
}
