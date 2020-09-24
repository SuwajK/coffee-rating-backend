package com.krzysiek.coffeerating.repository;

import com.krzysiek.coffeerating.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
}
