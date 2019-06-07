package com.example.demo.dto;


import com.example.demo.dao.Books;
import com.example.demo.dao.Users;

import java.util.Date;


public class ReserwationsDto {

    private Date dateReserwation;
    private Integer idUser;
    private Integer idBook;

    public ReserwationsDto() {
    }

    public ReserwationsDto(Date dateReserwation, Integer idUser, Integer idBook) {
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
