package com.example.demo.dto;


public class CommentsDto {


    private String contentComment;
    private UsersDto idUser;
    private BooksDto idBook;

    public CommentsDto() {
    }

    public CommentsDto(String contentComment, UsersDto idUser, BooksDto idBook) {
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