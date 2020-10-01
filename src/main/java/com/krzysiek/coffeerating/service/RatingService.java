package com.krzysiek.coffeerating.service;

import com.krzysiek.coffeerating.model.Rating;
import com.krzysiek.coffeerating.repository.RatingRepository;
import com.krzysiek.coffeerating.repository.CoffeeMachineRepository;
import com.krzysiek.coffeerating.repository.GrindRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;
    private final CoffeeMachineRepository coffeeMachineRepository;
    private final GrindRepository grindRepository;

    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    public Rating getRatingById(Long id) {
        return ratingRepository.findById(id).orElseThrow();
    }
}
