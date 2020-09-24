package com.krzysiek.coffeerating.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class CoffeeMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String model;


    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "coffeeMachineId", updatable = false, insertable = false)
    private List<CoffeeMachineRecipe> machineRecipesList;

    public static final class Builder {
        private long id;
        private String brand;
        private String model;
        private List<CoffeeMachineRecipe> machineRecipesList = new ArrayList<>();


        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder addRecipe(CoffeeMachineRecipe coffeeMachineRecipe) {
            machineRecipesList.add(coffeeMachineRecipe);
            return this;
        }

        public CoffeeMachine build() {
            CoffeeMachine coffeeMachine = new CoffeeMachine();
            coffeeMachine.brand = brand;
            coffeeMachine.model = model;
            coffeeMachine.machineRecipesList = machineRecipesList;
            return coffeeMachine;
        }

    }
}
