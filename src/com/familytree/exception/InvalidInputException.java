package com.familytree.exception;

public class InvalidInputException extends Exception {
    public InvalidInputException(String errorMessage){
        super(errorMessage);
    }
}
