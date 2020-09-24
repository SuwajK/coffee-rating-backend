package com.krzysiek.coffeerating.service;

import com.krzysiek.coffeerating.model.Grinder;
import com.krzysiek.coffeerating.model.GrinderGrind;
import com.krzysiek.coffeerating.repository.GrinderGrindRepository;
import com.krzysiek.coffeerating.repository.GrinderRepository;
import com.krzysiek.coffeerating.repository.GrindRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GrinderService {
    private final GrindRepository grindRepository;
    private final GrinderRepository grinderRepository;
    private final GrinderGrindRepository grinderGrindsRepository;


    public List<Grinder> getGrinders() {
        return grinderRepository.findAll();
    }

    public Grinder getGrinderById(long id) {
        return grinderRepository.findById(id).orElseThrow();
    }

    public List<GrinderGrind> getGrinderGrindsByGrinderId(long id) {
        return grinderRepository.findById(id).orElseThrow().getGrinderGrinds();
    }


}
