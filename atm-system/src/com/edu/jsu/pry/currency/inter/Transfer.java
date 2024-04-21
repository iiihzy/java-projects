package com.edu.jsu.pry.currency.inter;

import com.edu.jsu.pry.user.User;

import java.util.ArrayList;

public interface Transfer{
    public void transfer(ArrayList<User> list, User user);
    public void transfer(ArrayList<User> list);
}
