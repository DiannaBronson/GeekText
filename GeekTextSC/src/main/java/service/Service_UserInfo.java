package service;


import model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.UsersInfoRepository;

import java.util.List;
import java.lang.Integer;

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
