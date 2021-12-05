package com.example.demo.service;

import com.example.demo.model.BookInfo;
import com.example.demo.respository.BookInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Service_BookInfo {
    @Autowired
    private BookInfoRepository newRepo;

    public List<BookInfo> listAllBooks(){
        return newRepo.findAll();
    }
    public BookInfo getBooks(Integer isbn)
    {
        return newRepo.findById(isbn).get();
    }


}
