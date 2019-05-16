package com.example.demo.repository;

import com.example.demo.dao.Reviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews,Integer> {

    @Query(value = "SELECT * FROM public.reviews",
            nativeQuery = true
    )
    List<Reviews> showReviews();

}