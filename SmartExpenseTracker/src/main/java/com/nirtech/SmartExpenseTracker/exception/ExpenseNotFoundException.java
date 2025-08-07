package com.nirtech.SmartExpenseTracker.exception;

public class ExpenseNotFoundException extends RuntimeException{
    public ExpenseNotFoundException(String message){
        super(message);
    }
}
