package com.suwajk.coffeerating.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BrewMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "brewMethodId", updatable = false, insertable = false)
    private List<Rating> brewMethodRecipesList;


    public void addRecipe(Rating rating) {
        if (brewMethodRecipesList == null) {
            brewMethodRecipesList = new ArrayList<>();
        }
        brewMethodRecipesList.add(rating);
    }

    public static final class Builder {
        private Long id;
        private String label;
        private List<Rating> brewMethodRecipesList;

        public Builder label(String label) {
            this.label = label;
            return this;
        }

        public Builder addRecipe(Rating rating) {
            if (brewMethodRecipesList == null) {
                brewMethodRecipesList = new ArrayList<>();
            }
            brewMethodRecipesList.add(rating);
            return this;
        }

        public BrewMethod build() {
            BrewMethod brewMethod = new BrewMethod();
            brewMethod.setLabel(label);
            brewMethod.brewMethodRecipesList = brewMethodRecipesList;
            return brewMethod;
        }
    }

}
