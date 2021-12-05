package com.example.demo.model;
import com.example.demo.model.Users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.mail.internet.AddressException;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.mail.internet.InternetAddress;

@Entity
@Data
@Table(name = "Users")
public class Users implements Serializable {

    @Id
    private int userId;

    private String userName;
    private String password;
    private String name;

    @Column(name = "email", updatable = false, nullable = true)
    private String email;
    private String streetAddr;
    private String city;
    private String state;

   // @OneToOne( mappedBy = "dbUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   // private CreditCard cards;


    public Users() {
    }

    public Users(int userId, String userName, String password, String name, String email, String streetAddr,
                 String city, String state) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
        this.streetAddr = streetAddr;
        this.city = city;
        this.state = state;
    }

    public static boolean isValidEmailAddr(String email)
    {
        boolean result = false;

        try {
            InternetAddress emailValid = new InternetAddress(email);
            emailValid.validate();
            result = true;
        } catch(AddressException e)
        {
            e.printStackTrace();
        }

        return result;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
       // if(isValidEmailAddr(userName)) {
            this.userName = userName;
       // }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
       // if(isValidEmailAddr(email)) {
            this.email = email;
       // }
    }

    public String getStreetAddr() {
        return streetAddr;
    }

    public void setStreetAddr(String streetAddr) {
        this.streetAddr = streetAddr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

   /* public CreditCard getCards() {
        return cards;
    }

    public void setCards(CreditCard cards) {
        this.cards = cards;
    }
*/
}