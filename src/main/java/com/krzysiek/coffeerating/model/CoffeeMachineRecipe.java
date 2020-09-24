package com.krzysiek.coffeerating.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime date;
    private long userId;
    private long rating;
    private long bitterness;
    private long sweetness;
    private String additional;


    public static class Builder {
        private long id;
        private long coffeeMachineId;
        private long grindId;
        private double waterDose;
        private double preinfusionDose;
        private LocalDateTime date;
        private long userId;
        private long rating;
        private long bitterness;
        private long sweetness;
        private String additional;

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

        public CoffeeMachineRecipe build() {
            CoffeeMachineRecipe coffeeMachineRecipe = new CoffeeMachineRecipe();
            coffeeMachineRecipe.coffeeMachineId = coffeeMachineId;
            coffeeMachineRecipe.grindId = grindId;
            coffeeMachineRecipe.preinfusionDose = preinfusionDose;
            coffeeMachineRecipe.waterDose = waterDose;
            coffeeMachineRecipe.date = date;
            coffeeMachineRecipe.userId = userId;
            coffeeMachineRecipe.rating = rating;
            coffeeMachineRecipe.bitterness = bitterness;
            coffeeMachineRecipe.sweetness = sweetness;
            coffeeMachineRecipe.additional = additional;
            return coffeeMachineRecipe;
        }


    }
}
