package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "CreditCard")
public class CreditCard {

    @Id
    @JsonIgnore
    private int ccId;

    private int userId;
    private String ccNum;
    private String expDate;
    private String secCode;
    private String name;

    public CreditCard() {
    }

    public int getCcId() {
        return ccId;
    }

    public void setCcId(int ccId) {
        this.ccId = ccId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCcNum() {
        return ccNum;
    }

    public void setCcNum(String ccNum) {
        this.ccNum = ccNum;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getSecCode() {
        return secCode;
    }

    public void setSecCode(String secCode) {
        this.secCode = secCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreditCard(int userId, String ccNum, String expDate, String secCode, String name )
    {
        //this.ccId = ccId;
        this.userId = userId;
        this.ccNum = ccNum;
        this.expDate = expDate;
        this.secCode = secCode;
        this.name = name;
        //this.dbUser = dbUser;
    }
}
