package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "BookInfo")
public class BookInfo {

    private int isbn;
    private String Bookname;
    private String author;
    private int genre;
    private int rating;
    private String comments;
    private float price;
    String publisher;
    String name;

    public String getBookname() {
        return Bookname;
    }

    public void setBookname(String bookname) {
        Bookname = bookname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setName(String Bookname) {
        this.Bookname = Bookname;
    }

    public BookInfo() {
    }

    public BookInfo(int isbn, String Bookname, String author, int genre, int rating, String comments)
    {
        this.isbn = isbn;
        this.Bookname = Bookname;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.comments= comments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return Bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
