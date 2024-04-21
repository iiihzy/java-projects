package com.edu.jsu.pry.myexception;

public class NameFormatException extends Exception{
    public NameFormatException() {
    }

    public NameFormatException(String message) {
        super(message);
    }
}
