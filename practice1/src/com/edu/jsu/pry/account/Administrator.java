package com.edu.jsu.pry.account;

import java.util.ArrayList;

public class Administrator {
    public ArrayList<User> list = new ArrayList<>();


    public void choose() {
        new Menu().choose(list);
    }
}
