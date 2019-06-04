package com.example.demo.dto;

import com.example.demo.dao.Books;
import com.example.demo.dao.Users;

public class ReviewsDto {


    private String contentReview;
    private Integer idUser;
    private Integer idBook;

    public ReviewsDto() {
    }

    public ReviewsDto(String contentReview, Integer idUser, Integer idBook) {
        this.contentReview = contentReview;
        this.idUser = idUser;
        this.idBook = idBook;
    }


    public String getContentReview() {
        return contentReview;
    }

    public void setContentReview(String contentReview) {
        this.contentReview = contentReview;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }
}

