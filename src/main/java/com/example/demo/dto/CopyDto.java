package com.example.demo.dto;


import com.example.demo.dao.Books;

public class CopyDto {

    private Integer idBook;

    public CopyDto() {
    }

    public CopyDto(Integer idBook) {
        this.idBook = idBook;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }
}