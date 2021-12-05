package com.example.demo.service;

import com.example.demo.model.Users;
import com.example.demo.respository.UsersInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Service_UsersInfo {

    @Autowired
    private UsersInfoRepository usersData;

    public List<Users> listAllUsers(){
        return usersData.findAll();
    }

    public Users getaUsers(Integer userId)
    {
        //return usersData.findbyUser(userName)

        return usersData.findById(userId).get();
    }

    public Users save(Users user) {

        return usersData.save(user);

    }

}
