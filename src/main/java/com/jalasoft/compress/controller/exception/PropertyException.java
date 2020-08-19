package com.jalasoft.compress.controller.exception;

public class PropertyException extends Exception{
    private static final String MESSAGE = "Error";

    public PropertyException() {
        super(MESSAGE);
    }

    public PropertyException(Throwable ex){
        super(MESSAGE, ex);
    }

    public PropertyException(String currentMessage, Throwable ex){
        super(currentMessage, ex);
    }

    public PropertyException(String currentMessage){
        super(currentMessage);
    }
}
