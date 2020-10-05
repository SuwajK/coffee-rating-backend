package com.krzysiek.coffeerating.service;

import com.krzysiek.coffeerating.model.Coffee;
import com.krzysiek.coffeerating.repository.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;

    public List<Coffee> getCoffees() {
        return coffeeRepository.findAll();
    }

    public Coffee addCoffee(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    public Coffee getCoffeeById(long id) {
        return coffeeRepository.findById(id).orElseThrow();
    }

    public Coffee getCoffeeByBrandAndName(String brand, String name) {
        return coffeeRepository.findByBrandAndName(brand, name);
    }

    public Coffee getCoffeeByCoffeeObject(Coffee coffee) {
        String brand = coffee.getBrand();
        String name = coffee.getName();
        return coffeeRepository.findByBrandAndName(brand, name);
    }
}
