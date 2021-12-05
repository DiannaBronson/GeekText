package com.example.demo.controller;

import com.example.demo.model.BookInfo;
import com.example.demo.model.CreditCard;
import com.example.demo.model.Users;
import com.example.demo.service.Service_BookInfo;
import com.example.demo.service.Service_CreditCard;
import org.jetbrains.annotations.TestOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/CreditCard")
public class GenreController_CreditCardInfo {

    @Autowired
    Service_CreditCard userServiceCreditCard;

    @GetMapping("/all")
    public List<CreditCard> listing()
    {
        return userServiceCreditCard.listAllCreditCards();
    }



    @GetMapping("/{userId}")
    public ResponseEntity<CreditCard> get(@PathVariable Integer userId)
    {

        //try{
            CreditCard cc;
            cc = userServiceCreditCard.getCards(userId);
            return new ResponseEntity<CreditCard>(cc, HttpStatus.OK);
       // }catch (NoSuchElementException e)
       // {
       //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      //  }

       // CreditCard user;
       // user = userServiceCreditCard.getCards(userId);

           // return new ResponseEntity<Users>( userServiceCreditCard.getCards(userId), HttpStatus.OK);

    }

    @PostMapping("/new")
    public ResponseEntity<CreditCard> addUser(@RequestBody CreditCard userCreditCard) throws URISyntaxException
    {
        CreditCard user;
        user = userServiceCreditCard.save(userCreditCard);
        return ResponseEntity.created(new URI("Users/" + user.getUserId())).body(userCreditCard);


    }

}
