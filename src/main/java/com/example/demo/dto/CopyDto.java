package com.example.demo.dto;


import com.example.demo.dao.Books;

public class CopyDto {

    private Books idBook;

    public CopyDto() {
    }

    public CopyDto(Books idBook) {
        this.idBook = idBook;
    }

    public Books getIdBook() {
        return idBook;
    }

    public void setIdBook(Books idBook) {
        this.idBook = idBook;
    }
}