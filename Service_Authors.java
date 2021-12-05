package com.example.demo.service;

import com.example.demo.model.Authors;
import com.example.demo.respository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional

public class Service_Authors {

    @Autowired
    private AuthorsRepository newRepo;

    public List<Authors> listAllBooks(){
        return newRepo.findAll();
    }
    public Authors getBooks(String firstName)
    {
        return newRepo.findById(firstName);
    }

}
