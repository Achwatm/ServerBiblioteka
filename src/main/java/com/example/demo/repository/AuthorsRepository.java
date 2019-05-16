package com.example.demo.repository;

import com.example.demo.dao.Authors;
import com.example.demo.dao.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors,Integer> {

    @Query(value = "SELECT * FROM public.authors",
            nativeQuery = true
    )
    List<Authors> showAuthors();



}