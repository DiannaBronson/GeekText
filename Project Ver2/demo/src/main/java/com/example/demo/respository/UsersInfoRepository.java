package com.example.demo.respository;

import com.example.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersInfoRepository extends JpaRepository<Users, Integer>
{
    List<Users> findByuserName(String userName);
}


