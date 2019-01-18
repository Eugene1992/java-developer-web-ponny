package com.cbsystematics.edu.internet_shop.exceptions;

public class WrongPasswordRegisterException extends Exception {

    public WrongPasswordRegisterException() {
    }

    public WrongPasswordRegisterException(String message) {
        fillInStackTrace();
    }

    public WrongPasswordRegisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongPasswordRegisterException(Throwable cause) {
        super(cause);
    }

    public WrongPasswordRegisterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
