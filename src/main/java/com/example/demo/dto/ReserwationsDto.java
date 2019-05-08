package com.example.demo.dto;


import java.util.Date;


public class ReserwationsDto {

    private Date dateReserwation;
    private UsersDto idUser;
    private BooksDto idBook;

    public ReserwationsDto() {
    }

    public ReserwationsDto(Date dateReserwation, UsersDto idUser, BooksDto idBook) {
        this.dateReserwation = dateReserwation;
        this.idUser = idUser;
        this.idBook = idBook;
    }


    public Date getDateReserwation() {
        return dateReserwation;
    }

    public void setDateReserwation(Date dateReserwation) {
        this.dateReserwation = dateReserwation;
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
