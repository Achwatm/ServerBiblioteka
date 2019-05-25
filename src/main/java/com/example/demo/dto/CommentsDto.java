package com.example.demo.dto;


import com.example.demo.dao.Books;
import com.example.demo.dao.Users;

public class CommentsDto {


    private String contentComment;
    private Users idUser;
    private Books idBook;

    public CommentsDto() {
    }

    public CommentsDto(String contentComment, Users idUser, Books idBook) {
        this.contentComment = contentComment;
        this.idUser = idUser;
        this.idBook = idBook;
    }


    public String getContentComment() {
        return contentComment;
    }

    public void setContentComment(String contentComment) {
        this.contentComment = contentComment;
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