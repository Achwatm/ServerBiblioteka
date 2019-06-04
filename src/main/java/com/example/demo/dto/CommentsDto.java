package com.example.demo.dto;


import com.example.demo.dao.Books;
import com.example.demo.dao.Users;

public class CommentsDto {


    private String contentComment;
    private Integer idUser;
    private Integer idBook;

    public CommentsDto() {
    }

    public CommentsDto(String contentComment, Integer idUser, Integer idBook) {
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