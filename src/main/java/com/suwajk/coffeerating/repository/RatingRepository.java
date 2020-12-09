package com.suwajk.coffeerating.repository;

import com.suwajk.coffeerating.model.Rating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends PagingAndSortingRepository<Rating, Long> {

    @Override
    Iterable<Rating> findAll(Sort sort);

    @Override
    Page<Rating> findAll(Pageable pageable);
}
