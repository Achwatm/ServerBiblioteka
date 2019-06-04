package com.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.javafx.geom.Edge;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors",schema = "public")

public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_author")
    private Integer idAuthor;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;


    public List<Books> getBooks() {
        return books;
    }

//    public void setBooks(List<Books> books) {
//        this.books = books;
//    }

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "id_author")
    private List<Books> books;

    public Authors() {
    }

    public Authors(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

