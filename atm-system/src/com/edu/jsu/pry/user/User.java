package com.edu.jsu.pry.user;

import com.edu.jsu.pry.myexception.IdFormatException;
import com.edu.jsu.pry.myexception.MoneySetEXception;
import com.edu.jsu.pry.myexception.NameFormatException;
import com.edu.jsu.pry.myexception.TelephoneNumberException;

import java.io.Serial;
import java.io.Serializable;

public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 9191003616561417527L;
    private String password;
    private String phoneNumber;
    private String id;
    private String name;
    private int deposit;
    private String idCard;
    private String telephoneNumber;

    public User() {
    }

    public User(String name, String password, String id, String phoneNumber) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws NameFormatException {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public User(String telephoneNumber, String password) {
        this.password = password;
        this.telephoneNumber = telephoneNumber;
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

    public void setId(String id) throws IdFormatException {
        if(id.length() != 10)
            throw new IdFormatException();
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws NameFormatException {
        if(name.length() < 2 || name.length() > 10)
            throw new NameFormatException();
        this.name = name;
    }


    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) throws MoneySetEXception {
        if(deposit < 0)
            throw new MoneySetEXception();
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

    public void setTelephoneNumber(String telephoneNumber) throws TelephoneNumberException {
            if (telephoneNumber == null || !telephoneNumber.matches("^\\d{11}$")) {
                throw new TelephoneNumberException();
            }

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
