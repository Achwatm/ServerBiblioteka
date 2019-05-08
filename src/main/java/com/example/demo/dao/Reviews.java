package com.example.demo.dao;

import javax.persistence.*;

@Entity
@Table(name = "reviews",schema = "public")

public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review")
    private Integer idReview;
    @Column(name = "content_review")
    private String contentReview;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users idUser;
    @ManyToOne
    @JoinColumn(name = "id_book")
    private Books idBook;

    public Reviews() {
    }

    public Reviews(String contentReview, Users idUser, Books idBook) {
        this.contentReview = contentReview;
        this.idUser = idUser;
        this.idBook = idBook;
    }

    public Integer getIdReview() {
        return idReview;
    }

    public void setIdReview(Integer idReview) {
        this.idReview = idReview;
    }

    public String getContentReview() {
        return contentReview;
    }

    public void setContentReview(String contentReview) {
        this.contentReview = contentReview;
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

