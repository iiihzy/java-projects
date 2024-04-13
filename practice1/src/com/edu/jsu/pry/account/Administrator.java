package com.edu.jsu.pry.account;

import java.io.IOException;
import java.util.ArrayList;

public class Administrator {
    public ArrayList<User> list = new ArrayList<>();

    public void choose() throws IOException {
        new TextFileInput().textFileReader(list);
        new Menu().choose(list);
    }
}
