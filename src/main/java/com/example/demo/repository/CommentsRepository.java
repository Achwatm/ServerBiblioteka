package com.example.demo.repository;

import com.example.demo.dao.Comments;
import com.example.demo.dao.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Integer> {

    @Query(value = "SELECT * FROM public.comments",
            nativeQuery = true
    )
    List<Comments> showComments();

}