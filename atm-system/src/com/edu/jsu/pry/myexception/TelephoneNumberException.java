package com.edu.jsu.pry.myexception;

import java.io.Serial;

public class TelephoneNumberException extends Exception{
    @Serial
    private static final long serialVersionUID = -5955061046050703141L;

    public TelephoneNumberException() {
    }

    public TelephoneNumberException(String message) {
        super(message);
    }
}
