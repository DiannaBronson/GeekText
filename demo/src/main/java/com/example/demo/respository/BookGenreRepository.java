package com.example.demo.respository;


import com.example.demo.model.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookGenreRepository extends JpaRepository<BookGenre, Integer>{}
