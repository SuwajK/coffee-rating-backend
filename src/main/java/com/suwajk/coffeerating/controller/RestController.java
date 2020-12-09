package com.suwajk.coffeerating.controller;


import com.suwajk.coffeerating.model.*;
import com.suwajk.coffeerating.service.*;
import lombok.RequiredArgsConstructor;
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
    private final BrewMethodsService brewMethodsService;

    @GetMapping("/grinders")
    public List<Grinder> getAllGrinders() {
        return grinderService.getGrinders();
    }

    @GetMapping("/grinders/{id}")
    public Grinder getGrinderById(@PathVariable long id) {
        return grinderService.getGrinderById(id);
    }

    @PostMapping("/grinders")
    public Grinder addGrinder(@RequestBody Grinder grinder) {
        return grinderService.addGrinder(grinder);
    }

    @DeleteMapping("/grinders")
    public void deleteGrinder(@RequestBody Grinder grinder) {
        grinderService.deleteGrinder(grinder);
    }

    @DeleteMapping("/grinders/{id}")
    public void deleteGrinderById(@PathVariable long id) {
        grinderService.deleteGrinderById(id);
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
        System.out.println(rating.toString());
        Coffee coffee = coffeeService.getCoffeeByCoffeeObject(rating.getCoffee());
        rating.setCoffee(coffee);
        return ratingService.addRating(rating);
    }

    @DeleteMapping("/ratings")
    public void deleteRating(@RequestBody Rating rating) {
        ratingService.deleteRating(rating);
    }

    @DeleteMapping("/ratings/{id}")
    public void deleteRating(@PathVariable long id) {
        ratingService.deleteRatingById(id);
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

    @DeleteMapping("/coffees")
    public void deleteCoffee(@RequestBody Coffee coffee) {
        coffeeService.deleteCoffee(coffee);
    }

    @DeleteMapping("/coffees/{id}")
    public void deleteCoffeeById(@PathVariable long id) {
        coffeeService.deleteCoffeeById(id);
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

    @DeleteMapping("/coffeemachines")
    public void deleteCoffeeMachine(@RequestBody CoffeeMachine coffeemachine) {
        coffeeMachineService.deleteCoffeeMachine(coffeemachine);
    }

    @DeleteMapping("/coffeemachines/{id}")
    public void deleteCoffeeMachineById(@PathVariable long id) {
        coffeeMachineService.deleteCoffeeMachineById(id);
    }

    @GetMapping("/methods")
    public List<BrewMethod> getBrewMethods() {
        return brewMethodsService.getAllBrewMethods();
    }
}
