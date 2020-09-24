package com.krzysiek.coffeerating.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime date;
    private long userId;
    private long rating;
    private long bitterness;
    private long sweetness;
    private String additional;


    @ManyToMany(mappedBy = "ratingsList")
    @JsonBackReference
    private List<CoffeeMachineRecipe> recipesList = new ArrayList<>();

    public static class Builder {

        private long id;
        private LocalDateTime date;
        private long userId;
        private long rating;
        private long bitterness;
        private long sweetness;
        private String additional;
        private List<CoffeeMachineRecipe> recipesList = new ArrayList<>();

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder date(LocalDateTime date) {
            this.date = date;
            return this;
        }

        public Builder userId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder rating(long rating) {
            this.rating = rating;
            return this;
        }

        public Builder bitterness(long bitterness) {
            this.bitterness = bitterness;
            return this;
        }

        public Builder sweetness(long sweetness) {
            this.sweetness = sweetness;
            return this;
        }

        public Builder additional(String additional) {
            this.additional = additional;
            return this;
        }

        public Builder addRecipe(CoffeeMachineRecipe coffeeMachineRecipe) {
            this.recipesList.add(coffeeMachineRecipe);
            return this;
        }

        public Rating build() {
            Rating coffeeRating = new Rating();
            coffeeRating.id = id;
            coffeeRating.date = date;
            coffeeRating.userId = userId;
            coffeeRating.rating = rating;
            coffeeRating.bitterness = bitterness;
            coffeeRating.sweetness = sweetness;
            coffeeRating.additional = additional;
            return coffeeRating;
        }
    }
}
