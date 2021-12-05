package com.example.demo.service;

import com.example.demo.model.CreditCard;
import com.example.demo.model.Users;
import com.example.demo.respository.CreditCardRepository;
import com.example.demo.respository.UsersInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Service_CreditCard {

    @Autowired
    private CreditCardRepository usersCreditCard;

    public List<CreditCard> listAllCreditCards() {
        return usersCreditCard.findAll();
    }

    public CreditCard getCards(Integer userId) {
        //return usersData.findbyUser(userName)

        return usersCreditCard.findByUserId(userId).get(0);
                //findByUserId(userId).get(0);

        //.get();
    }

    public CreditCard save(CreditCard user) {

        return usersCreditCard.save(user);

    }

}