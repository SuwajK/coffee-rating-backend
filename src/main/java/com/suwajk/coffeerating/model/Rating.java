package com.suwajk.coffeerating.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long coffeeMachineId;
    private long brewMethodId;
    @OneToOne
    private Coffee coffee;
    private long grindId;
    private double waterDose;
    private double coffeeDose;
    private double brewTime;
    private double preinfusionDose;
    private double preinfusionTime;
    private LocalDateTime date;
    private long userId;
    private long rating;


//    private long coffeeId;
//    private long bitterness;
//    private long sweetness;
//    private String additional;


    public static class Builder {
        private long id;
        private long coffeeMachineId;
        private long brewMethodId;
        private Coffee coffee;
        private long grindId;
        private double waterDose;
        private double coffeeDose;
        private double brewTime;
        private double preinfusionDose;
        private double preinfusionTime;
        private LocalDateTime date;
        private long userId;
        private long rating;
//        private long bitterness;
//        private long sweetness;
//        private String additional;

        public Builder coffeeMachineId(long coffeeMachineId) {
            this.coffeeMachineId = coffeeMachineId;
            return this;
        }

        public Builder brewMethodId(long brewMethodId) {
            this.brewMethodId = brewMethodId;
            return this;
        }

        public Builder coffeeId(Coffee coffee) {
            this.coffee = coffee;
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

        public Builder coffeeDose(double coffeeDose) {
            this.coffeeDose = coffeeDose;
            return this;
        }

        public Builder brewTime(double brewTime) {
            this.brewTime = brewTime;
            return this;
        }

        public Builder preinfusionDose(double preinfusionDose) {
            this.preinfusionDose = preinfusionDose;
            return this;
        }

        public Builder preinfusionTime(double preinfusionTime) {
            this.preinfusionTime = preinfusionTime;
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

//        public Builder bitterness(long bitterness) {
//            this.bitterness = bitterness;
//            return this;
//        }
//
//        public Builder sweetness(long sweetness) {
//            this.sweetness = sweetness;
//            return this;
//        }
//
//        public Builder additional(String additional) {
//            this.additional = additional;
//            return this;
//        }

        public Rating build() {
            Rating rating = new Rating();
            rating.coffeeMachineId = coffeeMachineId;
            rating.brewMethodId = brewMethodId;
            rating.coffee = coffee;
            rating.grindId = grindId;
            rating.brewTime = brewTime;
            rating.preinfusionDose = preinfusionDose;
            rating.preinfusionTime = preinfusionTime;
            rating.waterDose = waterDose;
            rating.coffeeDose = coffeeDose;
            rating.date = date;
            rating.userId = userId;
            rating.rating = this.rating;
            return rating;
        }


    }
}
