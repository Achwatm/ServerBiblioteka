package com.example.demo.dto;


import com.example.demo.dao.Authors;

public class BooksDto {


    private String title;
    private String description;
    private String type;
    private Authors idAuthor;

    public BooksDto() {
    }

    public BooksDto(String title, String description, String type, Authors idAuthor) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.idAuthor = idAuthor;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Authors getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Authors idAuthor) {
        this.idAuthor = idAuthor;
    }
}

