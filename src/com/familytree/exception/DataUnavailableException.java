package com.familytree.exception;

public class DataUnavailableException extends Exception{
    public DataUnavailableException(String errorMessage){
        super(errorMessage);
    }
}
