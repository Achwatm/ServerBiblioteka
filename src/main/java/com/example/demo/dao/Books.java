package com.example.demo.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;

@Entity
@Table(name = "books",schema = "public")


public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Integer idBook;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "type")
    private String type;
    @ManyToOne(cascade = CascadeType.ALL)
//    @JsonIgnore
    @JoinColumn(name = "id_author")
    private Authors idAuthor;

    public Books() {
    }

    public Books(String title, String description, String type, Authors idAuthor) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.idAuthor = idAuthor;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
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

