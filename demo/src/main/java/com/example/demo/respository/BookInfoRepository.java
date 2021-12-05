package com.example.demo.respository;

import com.example.demo.model.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookInfoRepository extends JpaRepository<BookInfo, Integer> {}