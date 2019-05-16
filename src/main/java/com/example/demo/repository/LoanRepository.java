package com.example.demo.repository;

import com.example.demo.dao.Loan;
import com.example.demo.dao.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {

    @Query(value = "SELECT * FROM public.loan",
            nativeQuery = true
    )
    List<Loan> showLoan();

}