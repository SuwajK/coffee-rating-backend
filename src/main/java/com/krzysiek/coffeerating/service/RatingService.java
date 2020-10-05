package com.krzysiek.coffeerating.service;

import com.krzysiek.coffeerating.model.Rating;
import com.krzysiek.coffeerating.repository.CoffeeRepository;
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
    private final CoffeeRepository coffeeRepository;

    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    public Rating getRatingById(Long id) {
        return ratingRepository.findById(id).orElseThrow();
    }

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating editRating(Rating editedRating) {
        Rating originalRating = ratingRepository.findById(editedRating.getId()).orElseThrow();
        originalRating.setCoffeeMachineId(editedRating.getCoffeeMachineId());
        originalRating.setGrindId(editedRating.getGrindId());
        originalRating.setBrewTime(editedRating.getBrewTime());
        originalRating.setPreinfusionDose(editedRating.getPreinfusionDose());
        originalRating.setPreinfusionTime(editedRating.getPreinfusionTime());
        originalRating.setWaterDose(editedRating.getWaterDose());
        originalRating.setDate(editedRating.getDate());
        originalRating.setRating(editedRating.getRating());
        return originalRating;
    }
}
