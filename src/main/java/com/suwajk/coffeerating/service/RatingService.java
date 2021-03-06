package com.suwajk.coffeerating.service;

import com.suwajk.coffeerating.model.Rating;
import com.suwajk.coffeerating.repository.CoffeeMachineRepository;
import com.suwajk.coffeerating.repository.CoffeeRepository;
import com.suwajk.coffeerating.repository.GrindRepository;
import com.suwajk.coffeerating.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;
    private final CoffeeMachineRepository coffeeMachineRepository;
    private final GrindRepository grindRepository;
    private final CoffeeRepository coffeeRepository;

    public List<Rating> getRatings() {
        List<Rating> list = new ArrayList<>();
        Iterable<Rating> ratings = ratingRepository.findAll();
        ratings.iterator().forEachRemaining(list::add);
        return list;
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

    public void deleteRating(Rating rating) {
        ratingRepository.delete(rating);
    }

    public void deleteRatingById(long id) {
        ratingRepository.deleteById(id);
    }
}
