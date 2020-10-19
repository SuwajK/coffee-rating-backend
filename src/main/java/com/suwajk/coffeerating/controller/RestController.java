package com.suwajk.coffeerating.controller;


import com.suwajk.coffeerating.model.Coffee;
import com.suwajk.coffeerating.model.CoffeeMachine;
import com.suwajk.coffeerating.model.Rating;
import com.suwajk.coffeerating.model.Grinder;
import com.suwajk.coffeerating.service.CoffeeMachineService;
import com.suwajk.coffeerating.service.CoffeeService;
import com.suwajk.coffeerating.service.RatingService;
import com.suwajk.coffeerating.service.GrinderService;
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
    private final RatingService ratingService;
    private final GrinderService grinderService;
    private final CoffeeService coffeeService;
    private final CoffeeMachineService coffeeMachineService;

    @GetMapping("/grinders")
    public List<Grinder> getAllGrinders() {
        return grinderService.getGrinders();
    }

    @GetMapping("/grinders/{id}")
    public Grinder getGrinderById(@PathVariable long id) {
        return grinderService.getGrinderById(id);
    }


    @GetMapping("/ratings")
    public List<Rating> getRatings() {
        return ratingService.getRatings();
    }

    @GetMapping("/ratings/{id}")
    public Rating getRatingById(@PathVariable long id) {
        return ratingService.getRatingById(id);
    }

    @PostMapping("/ratings")
    public Rating addRating(@RequestBody Rating rating) {
        if (rating.getCoffee().getBrand().isEmpty() || rating.getCoffee().getName().isEmpty()) {
            rating.setCoffee(coffeeService.getCoffeeById(1));
        } else if (coffeeService.getCoffeeByCoffeeObject(rating.getCoffee()) == null) {
            coffeeService.addCoffee(rating.getCoffee());
        }
        Coffee coffee = coffeeService.getCoffeeByCoffeeObject(rating.getCoffee());
        rating.setCoffee(coffee);
        return ratingService.addRating(rating);
    }


    @GetMapping("/coffees")
    public List<Coffee> getCoffees() {
        return coffeeService.getCoffees();
    }

    @GetMapping("/coffees/{id}")
    public Coffee getCoffeeById(@PathVariable long id) {
        return coffeeService.getCoffeeById(id);
    }

    @PostMapping("/coffees")
    public Coffee addCoffee(@RequestBody Coffee coffee) {
        return coffeeService.addCoffee(coffee);
    }


    @GetMapping("/coffeemachines")
    public List<CoffeeMachine> getAllCoffeeMachines() {
        return coffeeMachineService.getAllCoffeeMachines();
    }

    @GetMapping("/coffeemachines/{id}")
    public CoffeeMachine getCoffeeMachineById(@PathVariable long id) {
        return coffeeMachineService.getCoffeeMachineById(id);
    }

    @PostMapping("/coffeemachines")
    public CoffeeMachine addCoffeeMachine(@RequestBody CoffeeMachine coffeeMachine) {
        return coffeeMachineService.addCoffeeMachine(coffeeMachine);
    }
}
