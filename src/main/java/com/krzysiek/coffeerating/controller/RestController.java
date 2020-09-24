package com.krzysiek.coffeerating.controller;


import com.krzysiek.coffeerating.model.CoffeeMachineRecipe;
import com.krzysiek.coffeerating.model.Grinder;
import com.krzysiek.coffeerating.service.CoffeeRecipeService;
import com.krzysiek.coffeerating.service.GrinderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RequiredArgsConstructor
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    private final CoffeeRecipeService coffeeRecipeService;
    private final GrinderService grinderService;

    @GetMapping("/grinders")
    public List<Grinder> getAllGrinders() {
        return grinderService.getGrinders();
    }

    @GetMapping("/grinders/{id}")
    public Grinder getGrinderById(@PathVariable long id) {
        return grinderService.getGrinderById(id);
    }

    @GetMapping("/recipes")
    public List<CoffeeMachineRecipe> getAllCoffeeMachineRecipes() {
        return coffeeRecipeService.getCoffeeMachineRecipes();
    }

    @GetMapping("/recipes/{id}")
    public CoffeeMachineRecipe getCoffeeMachineRecipeById(@PathVariable long id) {
        return coffeeRecipeService.getCoffeeMachineRecipeById(id);
    }
}
