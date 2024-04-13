package com.edu.jsu.pry.myexception;

public class PassWordFormatException extends Exception{
    public PassWordFormatException() {
    }

    public PassWordFormatException(String message) {
        super(message);
    }
}
