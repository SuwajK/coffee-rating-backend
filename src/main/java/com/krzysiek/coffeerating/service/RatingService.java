package com.krzysiek.coffeerating.service;

import com.krzysiek.coffeerating.model.Rating;
import com.krzysiek.coffeerating.repository.CoffeeMachineRecipeRepository;
import com.krzysiek.coffeerating.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final CoffeeMachineRecipeRepository coffeeMachineRecipeRepository;
    private final RatingRepository ratingRepository;

    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    public Rating getRatingById(long id) {
        return ratingRepository.findById(id).orElseThrow();
    }
}
