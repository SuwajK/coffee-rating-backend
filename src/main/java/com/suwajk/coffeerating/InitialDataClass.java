package com.suwajk.coffeerating;

import com.suwajk.coffeerating.model.*;
import com.suwajk.coffeerating.repository.*;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class InitialDataClass {

    private final RatingRepository ratingRepository;
    private final CoffeeMachineRepository coffeeMachineRepository;
    private final GrinderGrindRepository grinderGrindRepository;
    private final GrinderRepository grinderRepository;
    private final GrindRepository grindRepository;
    private final CoffeeRepository coffeeRepository;
    private final BrewMethodRepository brewMethodRepository;

    public InitialDataClass(RatingRepository ratingRepository,
                            CoffeeMachineRepository coffeeMachineRepository,
                            GrinderGrindRepository grinderGrindRepository,
                            GrinderRepository grinderRepository,
                            GrindRepository grindRepository,
                            CoffeeRepository coffeeRepository,
                            BrewMethodRepository brewMethodRepository) {

        this.ratingRepository = ratingRepository;
        this.coffeeMachineRepository = coffeeMachineRepository;
        this.grinderGrindRepository = grinderGrindRepository;
        this.grinderRepository = grinderRepository;
        this.grindRepository = grindRepository;
        this.coffeeRepository = coffeeRepository;
        this.brewMethodRepository = brewMethodRepository;

        BrewMethod method1 = new BrewMethod.Builder().label("Aeropress").build();
        BrewMethod method2 = new BrewMethod.Builder().label("Espresso Machine").build();
        BrewMethod method3 = new BrewMethod.Builder().label("Frenchpress").build();

        brewMethodRepository.save(method1);
        brewMethodRepository.save(method2);
        brewMethodRepository.save(method3);


        Grind grind1 = new Grind.Builder()
                .caption("EXTRA_SMALL")
                .level(1)
                .build();

        Grind grind2 = new Grind.Builder()
                .caption("SMALL")
                .level(2)
                .build();

        Grind grind3 = new Grind.Builder()
                .caption("MEDIUM")
                .level(3)
                .build();

        Grind grind4 = new Grind.Builder()
                .caption("LARGE")
                .level(4)
                .build();

        Grind grind5 = new Grind.Builder()
                .caption("EXTRA_LARGE")
                .level(5)
                .build();

        Grind grind6 = new Grind.Builder()
                .caption("XXXL")
                .level(6)
                .build();


        Grinder grinder = new Grinder.Builder()
                .brand("Xeoleo")
                .model("Hand grinder")
                .build();

        GrinderGrind grinderGrind1 = new GrinderGrind();
        grinderGrind1.setGrindId(grind1);
        grinderGrind1.setGrinderId(1);
        grinderGrind1.setClicks(0);

        GrinderGrind grinderGrind2 = new GrinderGrind();
        grinderGrind2.setGrindId(grind2);
        grinderGrind2.setGrinderId(1);
        grinderGrind2.setClicks(4);

        GrinderGrind grinderGrind3 = new GrinderGrind();
        grinderGrind3.setGrindId(grind3);
        grinderGrind3.setGrinderId(1);
        grinderGrind3.setClicks(8);

        GrinderGrind grinderGrind4 = new GrinderGrind();
        grinderGrind4.setGrindId(grind4);
        grinderGrind4.setGrinderId(1);
        grinderGrind4.setClicks(12);

        GrinderGrind grinderGrind5 = new GrinderGrind();
        grinderGrind5.setGrindId(grind5);
        grinderGrind5.setGrinderId(1);
        grinderGrind5.setClicks(16);

        GrinderGrind grinderGrind6 = new GrinderGrind();
        grinderGrind6.setGrindId(grind6);
        grinderGrind6.setGrinderId(1);
        grinderGrind6.setClicks(24);

        List<GrinderGrind> grindsList = new ArrayList<>();
        grindsList.add(grinderGrind1);
        grindsList.add(grinderGrind2);
        grindsList.add(grinderGrind3);
        grindsList.add(grinderGrind4);
        grindsList.add(grinderGrind5);
        grindsList.add(grinderGrind6);
        grinder.setGrinderGrinds(grindsList);

        CoffeeMachine coffeeMachine1 = new CoffeeMachine.Builder()
                .brand("Aeropress")
                .model("Aeropress")
                .build();

        CoffeeMachine coffeeMachine2 = new CoffeeMachine.Builder()
                .brand("Delonghi")
                .model("EC55.21")
                .build();

        Coffee coffee0 = new Coffee.Builder()
                .brand("None")
                .name("None")
                .build();

        Coffee coffee1 = new Coffee.Builder()
                .brand("Lavazza")
                .name("1")
                .build();

        Coffee coffee2 = new Coffee.Builder()
                .brand("Lavazza")
                .name("2")
                .build();

        Coffee coffee3 = new Coffee.Builder()
                .brand("Lavazza")
                .name("3")
                .build();

        Rating rating1 = new Rating.Builder()
                .coffeeMachineId(1)
                .brewMethodId(1)
                .coffeeId(coffee1)
                .waterDose(200.00)
                .coffeeDose(11)
                .preinfusionDose(30.00)
                .grindId(3)
                .date(LocalDateTime.now())
                .userId(1)
                .rating(4)
                .preinfusionTime(0)
                .brewTime(30)
                .build();

        Rating rating2 = new Rating.Builder()
                .coffeeMachineId(1)
                .brewMethodId(2)
                .coffeeId(coffee2)
                .waterDose(200.00)
                .coffeeDose(14)
                .preinfusionDose(30.00)
                .grindId(4)
                .date(LocalDateTime.now())
                .userId(1)
                .rating(3)
                .preinfusionTime(0)
                .brewTime(30)
                .build();

        Rating rating3 = new Rating.Builder()
                .coffeeMachineId(1)
                .brewMethodId(3)
                .coffeeId(coffee3)
                .waterDose(220.00)
                .coffeeDose(30)
                .preinfusionDose(30.00)
                .grindId(3)
                .date(LocalDateTime.now())
                .userId(1)
                .rating(4)
                .preinfusionTime(0)
                .brewTime(30)
                .build();

        Rating rating4 = new Rating.Builder()
                .coffeeMachineId(1)
                .brewMethodId(1)
                .coffeeId(coffee1)
                .waterDose(100.00)
                .coffeeDose(20)
                .preinfusionDose(30.00)
                .grindId(3)
                .date(LocalDateTime.now())
                .userId(1)
                .rating(1)
                .preinfusionTime(0)
                .brewTime(30)
                .build();

        Rating rating5 = new Rating.Builder()
                .coffeeMachineId(2)
                .brewMethodId(2)
                .coffeeId(coffee2)
                .waterDose(220.00)
                .coffeeDose(10)
                .preinfusionDose(30.00)
                .grindId(1)
                .date(LocalDateTime.now())
                .userId(1)
                .rating(1)
                .preinfusionTime(0)
                .brewTime(30)
                .build();

        Rating rating6 = new Rating.Builder()
                .coffeeMachineId(2)
                .brewMethodId(2)
                .coffeeId(coffee3)
                .waterDose(100.00)
                .coffeeDose(10)
                .preinfusionDose(30.00)
                .grindId(1)
                .date(LocalDateTime.now())
                .userId(1)
                .rating(2)
                .preinfusionTime(0)
                .brewTime(30)
                .build();

        coffeeRepository.save(coffee0);
        coffeeRepository.save(coffee1);
        coffeeRepository.save(coffee2);
        coffeeRepository.save(coffee3);

        grinderRepository.save(grinder);

        grindRepository.save(grind1);
        grindRepository.save(grind2);
        grindRepository.save(grind3);
        grindRepository.save(grind4);
        grindRepository.save(grind5);
        grindRepository.save(grind6);

        grinderGrindRepository.save(grinderGrind1);
        grinderGrindRepository.save(grinderGrind2);
        grinderGrindRepository.save(grinderGrind3);
        grinderGrindRepository.save(grinderGrind4);
        grinderGrindRepository.save(grinderGrind5);
        grinderGrindRepository.save(grinderGrind6);


        coffeeMachineRepository.save(coffeeMachine1);
        coffeeMachineRepository.save(coffeeMachine2);

        ratingRepository.save(rating1);
        ratingRepository.save(rating2);
        ratingRepository.save(rating3);
        ratingRepository.save(rating4);
        ratingRepository.save(rating5);
        ratingRepository.save(rating6);
    }


}
