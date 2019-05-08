package com.example.demo.dto;


public class CopyDto {

    private BooksDto idBook;

    public CopyDto() {
    }

    public CopyDto(BooksDto idBook) {
        this.idBook = idBook;
    }

    public BooksDto getIdBook() {
        return idBook;
    }

    public void setIdBook(BooksDto idBook) {
        this.idBook = idBook;
    }
}