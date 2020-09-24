package com.krzysiek.coffeerating.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class CoffeeMachineRecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long coffeeMachineId;
    private long grindId;
    private double waterDose;
    private double preinfusionDose;

    @ManyToMany
    @JoinTable(
            name = "ratings_list",
            joinColumns = @JoinColumn(name = "recipe_id", table = "ratings"),
            inverseJoinColumns = @JoinColumn(name = "rating_id")
    )
    private List<Rating> ratingsList = new ArrayList<>();

    public static class Builder {
        private long id;
        private long coffeeMachineId;
        private long grindId;
        private double waterDose;
        private double preinfusionDose;
        private List<Rating> ratingsList = new ArrayList<>();

        public Builder coffeeMachineId(long coffeeMachineId) {
            this.coffeeMachineId = coffeeMachineId;
            return this;
        }

        public Builder grindId(long grindId) {
            this.grindId = grindId;
            return this;
        }

        public Builder waterDose(double waterDose) {
            this.waterDose = waterDose;
            return this;
        }

        public Builder preinfusionDose(double preinfusionDose) {
            this.preinfusionDose = preinfusionDose;
            return this;
        }

        public Builder rating(Rating newRating) {
            ratingsList.add(newRating);
            return this;
        }

        public CoffeeMachineRecipe build() {
            CoffeeMachineRecipe coffeeMachineRecipe = new CoffeeMachineRecipe();
            coffeeMachineRecipe.coffeeMachineId = coffeeMachineId;
            coffeeMachineRecipe.grindId = grindId;
            coffeeMachineRecipe.preinfusionDose = preinfusionDose;
            coffeeMachineRecipe.waterDose = waterDose;
            coffeeMachineRecipe.ratingsList = ratingsList;
            return coffeeMachineRecipe;
        }


    }
}
