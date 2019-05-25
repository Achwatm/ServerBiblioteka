package com.example.demo.dto;


import com.example.demo.dao.Books;
import com.example.demo.dao.Users;

import java.util.Date;


public class ReserwationsDto {

    private Date dateReserwation;
    private Users idUser;
    private Books idBook;

    public ReserwationsDto() {
    }

    public ReserwationsDto(Date dateReserwation, Users idUser, Books idBook) {
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
