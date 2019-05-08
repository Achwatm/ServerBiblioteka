package com.example.demo.dao;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservations",schema = "public")

public class Reserwations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserwation")
    private Integer idReserwation;
    @Column(name = "date_reserwation")
    private Date dateReserwation;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private Users idUser;
    @ManyToOne
    @JoinColumn(name = "id_book")
    private Books idBook;

    public Reserwations() {
    }

    public Reserwations(Date dateReserwation, Users idUser, Books idBook) {
        this.dateReserwation = dateReserwation;
        this.idUser = idUser;
        this.idBook = idBook;
    }

    public Integer getIdReserwation() {
        return idReserwation;
    }

    public void setIdReserwation(Integer idReserwation) {
        this.idReserwation = idReserwation;
    }

    public Date getDateReserwation() {
        return dateReserwation;
    }

    public void setDateReserwation(Date dateReserwation) {
        this.dateReserwation = dateReserwation;
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
