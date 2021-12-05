package com.example.demo.controller;

import com.example.demo.model.Authors;
import com.example.demo.service.Service_Authors;
import com.example.demo.model.BookInfo;
import com.example.demo.service.Service_BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/BookInfo")

public class Authors_Controller {
    @Autowired
    Service_BookInfo userServiceBookInfo;


    @GetMapping("/all")
    public List<BookInfo> listing()
    {
        return userServiceBookInfo.listAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookInfo> get(@PathVariable Integer isbn)
    {
        try{
            BookInfo genre;
            genre = userServiceBookInfo.getBooks(isbn);
            return new ResponseEntity<BookInfo>(genre, HttpStatus.OK);
        }catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
