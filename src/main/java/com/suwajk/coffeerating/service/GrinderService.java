package com.suwajk.coffeerating.service;

import com.suwajk.coffeerating.model.Grind;
import com.suwajk.coffeerating.model.Grinder;
import com.suwajk.coffeerating.model.GrinderGrind;
import com.suwajk.coffeerating.repository.GrinderGrindRepository;
import com.suwajk.coffeerating.repository.GrinderRepository;
import com.suwajk.coffeerating.repository.GrindRepository;
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

    public Grinder addGrinder(Grinder grinder) {
        return grinderRepository.save(grinder);
    }

    public void deleteGrinder(Grinder grinder) {
        grinderRepository.delete(grinder);
    }

    public void deleteGrinderById(long id) {
        grinderRepository.deleteById(id);
    }

}
