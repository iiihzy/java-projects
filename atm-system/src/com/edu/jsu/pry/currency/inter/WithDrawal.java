package com.edu.jsu.pry.currency.inter;

import com.edu.jsu.pry.user.User;

import java.util.ArrayList;

public interface WithDrawal{
    public void withdrawal(ArrayList<User> list);

    public void withdrawal(User user);
}
