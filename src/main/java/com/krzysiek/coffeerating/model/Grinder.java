package com.krzysiek.coffeerating.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Grinder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String model;

    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "grinderId", updatable = false, insertable = false)
    private List<GrinderGrind> grinderGrinds;


    public static final class Builder {
        private long id;
        private String brand;
        private String model;
        private List<GrinderGrind> grinderGrinds = new ArrayList<>();


        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder addGrind(GrinderGrind grinderGrind) {
            grinderGrinds.add(grinderGrind);
            return this;
        }

        public Grinder build() {
            Grinder grinder = new Grinder();
            grinder.brand = brand;
            grinder.model = model;
            grinder.grinderGrinds = grinderGrinds;
            return grinder;
        }

    }
}
