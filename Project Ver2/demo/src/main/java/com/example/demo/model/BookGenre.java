package com.example.demo.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;


import javax.persistence.*;

@Entity
@Table (name = "BookGenre")
public class BookGenre {
    private int id;
    private String genre;

    public BookGenre() {
    }

    public BookGenre(int id, String genre)
    {
        this.id = id;
        this.genre = genre;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
