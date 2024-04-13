package com.edu.jsu.pry.myexception;

public class IdFormatException extends Exception{
    public IdFormatException() {
    }

    public IdFormatException(String message) {
        super(message);
    }
}
