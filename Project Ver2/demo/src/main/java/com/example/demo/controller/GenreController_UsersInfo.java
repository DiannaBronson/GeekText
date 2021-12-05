package com.example.demo.controller;
import java.net.*;

import com.example.demo.model.Users;
import com.example.demo.respository.UsersInfoRepository;
import com.example.demo.service.Service_UsersInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/User")
public class GenreController_UsersInfo {
    @Autowired
    Service_UsersInfo userService;
    @Autowired
    UsersInfoRepository test;

    @GetMapping("/all")
    public List<Users> listing()
    {
        return userService.listAllUsers();
    }

    @GetMapping("/findUser")//("/{userName}")
   @ResponseBody
    public ResponseEntity<List<Users>> get(@RequestParam("userName") String userName)
    {
        return new ResponseEntity<List<Users>>( test.findByuserName(userName), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Users> addUser(@RequestBody Users userDetails) throws URISyntaxException
    {
            Users user;
            user = userService.save(userDetails);
            return ResponseEntity.created(new URI("Users/" + user.getUserId())).body(userDetails);


    }

    @PutMapping("/update")
    public ResponseEntity<Users> updateUser(@RequestBody Users userDetails) throws URISyntaxException
    {
        //try {
        Users temp = test.findById(userDetails.getUserId()).get();
        System.out.println("val = " + temp.getStreetAddr());
        int id = temp.getUserId();

        if(userDetails.getCity() != null)
            temp.setCity(userDetails.getCity());
        if(userDetails.getUserName() != null)
            temp.setUserName(userDetails.getUserName());
        if(userDetails.getPassword() != null)
            temp.setPassword(userDetails.getPassword());
        if(userDetails.getState() != null)
            temp.setState(userDetails.getState());
        if(userDetails.getStreetAddr() != null)
            temp.setStreetAddr(userDetails.getStreetAddr());

        userService.save(temp);
        return ResponseEntity.created(new URI("Users" )).body(userDetails);
        //}atch()

    }


}
