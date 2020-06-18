package com.javabank;

public class IllegalWithdrawalException extends Exception {
    public IllegalWithdrawalException(String message) {
        super(message);
    }
}
