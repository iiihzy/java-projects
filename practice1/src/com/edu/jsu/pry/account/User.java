package com.edu.jsu.pry.account;

public class User {
    private String id;
    private String name;
    private int deposit;

    private String idCard;

    private String telephoneNumber;

    public User() {
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
