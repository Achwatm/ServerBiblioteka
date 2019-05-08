package com.example.demo.dto;

public class ReviewsDto {


    private String contentReview;
    private UsersDto idUser;
    private BooksDto idBook;

    public ReviewsDto() {
    }

    public ReviewsDto(String contentReview, UsersDto idUser, BooksDto idBook) {
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

    public UsersDto getIdUser() {
        return idUser;
    }

    public void setIdUser(UsersDto idUser) {
        this.idUser = idUser;
    }

    public BooksDto getIdBook() {
        return idBook;
    }

    public void setIdBook(BooksDto idBook) {
        this.idBook = idBook;
    }
}

