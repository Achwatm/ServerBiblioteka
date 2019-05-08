package com.example.demo.repository;

import com.example.demo.dao.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    @Query(value = "SELECT * FROM public.users",
            nativeQuery = true
    )
    List<Users> showUsers();


    Users findByEMail(String username);
}