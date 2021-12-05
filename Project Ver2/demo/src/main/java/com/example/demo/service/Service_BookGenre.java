package com.example.demo.service;

import com.example.demo.model.BookGenre;
import com.example.demo.respository.BookGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class Service_BookGenre {

    @Autowired
    private BookGenreRepository newRepo;
    public List<BookGenre> listAllGenre(){
        return newRepo.findAll();
    }
    public BookGenre getGenre(Integer id)
    {

        return newRepo.findById(id).get();
    }



}

