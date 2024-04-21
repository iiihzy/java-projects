package com.edu.jsu.pry.account;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        Administrator administrator = new Administrator();
        administrator.choose();
    }
}
