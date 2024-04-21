package com.edu.jsu.pry.account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    public static boolean isValidPassword(String password) {
        String pattern = "^(?=.*[0-9])(?=.*[a-zA-Z]).{6,18}$";

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);

        return m.matches();

    }

    /*public static void main(String[] args) {
        String[] passwords = {"123456", "abcdef", "123456abcdef", "abcdef123456", "123456abcdefg"};

        for (String password : passwords) {
            System.out.println(password + " is valid: " + isValidPassword(password));
        }
    }*/
}

