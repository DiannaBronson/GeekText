package com.example.demo.respository;

import com.example.demo.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepository extends JpaRepository<Authors, Long> {
    Authors findById(String firstName);
}