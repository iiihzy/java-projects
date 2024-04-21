package com.edu.jsu.pry.account.inter;

import com.edu.jsu.pry.user.User;

import java.util.ArrayList;

public interface QueryAccount{
    public void queryAccount(ArrayList<User> list);
    public void queryAccount(User user);

}
