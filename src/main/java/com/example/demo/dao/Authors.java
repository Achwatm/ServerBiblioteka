package com.example.demo.dao;

import javax.persistence.*;

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

