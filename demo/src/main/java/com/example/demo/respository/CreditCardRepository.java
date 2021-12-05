package com.example.demo.respository;

import com.example.demo.model.CreditCard;
import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {

    List<CreditCard> findByUserId(int dbUser);
}
