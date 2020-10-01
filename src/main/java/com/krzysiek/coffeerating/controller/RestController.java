package com.krzysiek.coffeerating.controller;


import com.krzysiek.coffeerating.model.Rating;
import com.krzysiek.coffeerating.model.Grinder;
import com.krzysiek.coffeerating.service.RatingService;
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
    private final RatingService ratingService;
    private final GrinderService grinderService;

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
        return ratingService.addRating(rating);
    }
}
