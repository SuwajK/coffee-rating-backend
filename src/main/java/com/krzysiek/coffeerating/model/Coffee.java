package com.krzysiek.coffeerating.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.aop.scope.ScopedObject;
import springfox.documentation.builders.BuilderDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String name;

    public static class Builder {
        private long id;
        private String brand;
        private String name;

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Coffee build() {
            Coffee coffee = new Coffee();
            coffee.setBrand(brand);
            coffee.setName(name);
            return coffee;
        }
    }
}
