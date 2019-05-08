package com.example.demo.dao;
import javax.persistence.*;

@Entity
@Table(name = "copy",schema = "public")

public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_copy")
    private Integer idCopy;
    @ManyToOne
    @JoinColumn(name = "id_book")
    private Books idBook;

    public Copy() {
    }

    public Copy(Books idBook) {
        this.idBook = idBook;
    }

    public Integer getIdCopy() {
        return idCopy;
    }

    public void setIdCopy(Integer idCopy) {
        this.idCopy = idCopy;
    }

    public Books getIdBook() {
        return idBook;
    }

    public void setIdBook(Books idBook) {
        this.idBook = idBook;
    }
}