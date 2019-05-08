package com.example.demo.dao;

import javax.persistence.*;

@Entity
@Table(name = "comments",schema = "public")

public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private Integer idComment;
    @Column(name = "content_comment")
    private String contentComment;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users idUser;
    @ManyToOne
    @JoinColumn(name = "id_book")
    private Books idBook;

    public Comments() {
    }

    public Comments(String contentComment, Users idUser, Books idBook) {
        this.contentComment = contentComment;
        this.idUser = idUser;
        this.idBook = idBook;
    }

    public Integer getIdComment() {
        return idComment;
    }

    public void setIdComment(Integer idComment) {
        this.idComment = idComment;
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