package com.suwajk.coffeerating.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class GrinderGrind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long clicks;
    private long grinderId;
    @OneToOne
    private Grind grindId;
}
