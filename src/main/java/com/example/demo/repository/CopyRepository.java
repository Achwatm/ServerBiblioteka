package com.example.demo.repository;

import com.example.demo.dao.Copy;
import com.example.demo.dao.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopyRepository extends JpaRepository<Copy,Integer> {

    @Query(value = "SELECT * FROM public.copy",
            nativeQuery = true
    )
    List<Copy> showCopy();

}