package com.edu.jsu.pry.currency.inter;

import com.edu.jsu.pry.user.User;

import java.util.ArrayList;

public interface Deposit{
    public void deposit(ArrayList<User> list);
    public void deposit(User user);
}
