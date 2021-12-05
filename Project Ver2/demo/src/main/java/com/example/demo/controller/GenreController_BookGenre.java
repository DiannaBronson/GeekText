package com.example.demo.controller;

import com.example.demo.model.BookGenre;
import com.example.demo.service.Service_BookGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/BookGenre")
public class GenreController_BookGenre {

    @Autowired
    Service_BookGenre userServiceBookGenre;

    @GetMapping("/all")
    public List<BookGenre> listing()
    {
        return userServiceBookGenre.listAllGenre();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookGenre> get(@PathVariable Integer id)
    {
        try{
            BookGenre genre;
            genre = userServiceBookGenre.getGenre(id);
            return new ResponseEntity<BookGenre>(genre, HttpStatus.OK);
        }catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
