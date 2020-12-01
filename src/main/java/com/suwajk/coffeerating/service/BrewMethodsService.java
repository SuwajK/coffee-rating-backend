package com.suwajk.coffeerating.service;

import com.suwajk.coffeerating.model.BrewMethod;
import com.suwajk.coffeerating.repository.BrewMethodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrewMethodsService {
    private final BrewMethodRepository brewMethodRepository;

    public List<BrewMethod> getAllBrewMethods() {
        return brewMethodRepository.findAll();
    }
}
