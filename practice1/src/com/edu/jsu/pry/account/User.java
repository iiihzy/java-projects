package com.edu.jsu.pry.account;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String username;
    private String password;
    private String personID;
    private String phoneNumber;
    private String id;
    private String name;
    private int deposit;
    private String idCard;
    private String telephoneNumber;

    public User() {
    }

    public User(String username, String password, String personID, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.personID = personID;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public User(String id, String name, int deposit) {
        this.id = id;
        this.name = name;
        this.deposit = deposit;
    }

    public User(String id, String name, int deposit, String idCard, String telephoneNumber) {
        this.id = id;
        this.name = name;
        this.deposit = deposit;
        this.idCard = idCard;
        this.telephoneNumber = telephoneNumber;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", deposit=" + deposit +
                ", idCard='" + idCard + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}
