package com.example.demo.repository;

import com.example.demo.dao.Authors;
import com.example.demo.dao.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Books,Integer> {

    @Query(value = "SELECT * FROM public.books",
            nativeQuery = true
    )
    List<Books> showBooks();


}