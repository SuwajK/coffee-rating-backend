package com.suwajk.coffeerating.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Grind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long level;
    private String caption;

    public static class Builder {
        private long id;
        private long level;
        private String caption;

        public Builder level(long level) {
            this.level = level;
            return this;
        }

        public Builder caption(String caption) {
            this.caption = caption;
            return this;
        }

        public Grind build() {
            Grind grind = new Grind();
            grind.caption = caption;
            grind.level = level;
            return grind;
        }

    }
}