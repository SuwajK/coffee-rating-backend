package com.suwajk.coffeerating.service;

import com.suwajk.coffeerating.model.Coffee;
import com.suwajk.coffeerating.model.CoffeeMachine;
import com.suwajk.coffeerating.repository.CoffeeMachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoffeeMachineService {

    private final CoffeeMachineRepository coffeeMachineRepository;

    public List<CoffeeMachine> getAllCoffeeMachines() {
        return coffeeMachineRepository.findAll();
    }

    public CoffeeMachine getCoffeeMachineById(long id) {
        return coffeeMachineRepository.findById(id).orElseThrow();
    }

    public CoffeeMachine addCoffeeMachine(CoffeeMachine coffeeMachine) {
        coffeeMachineRepository.save(coffeeMachine);
        return coffeeMachine;
    }

    public void deleteCoffeeMachine(CoffeeMachine coffeeMachine) {
        coffeeMachineRepository.delete(coffeeMachine);
    }

    public void deleteCoffeeMachineById(long id) {
        coffeeMachineRepository.deleteById(id);
    }


}
