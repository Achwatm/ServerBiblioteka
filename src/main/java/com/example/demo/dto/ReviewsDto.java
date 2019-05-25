package com.example.demo.dto;

import com.example.demo.dao.Books;
import com.example.demo.dao.Users;

public class ReviewsDto {


    private String contentReview;
    private Users idUser;
    private Books idBook;

    public ReviewsDto() {
    }

    public ReviewsDto(String contentReview, Users idUser, Books idBook) {
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

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public Books getIdBook() {
        return idBook;
    }

    public void setIdBook(Books idBook) {
        this.idBook = idBook;
    }
}

