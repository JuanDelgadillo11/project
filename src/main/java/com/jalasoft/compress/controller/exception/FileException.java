package com.jalasoft.compress.controller.exception;

public class FileException extends Exception{
    private static final String MESSAGE = "Error";

    public FileException() {
        super(MESSAGE);
    }

    public FileException(Throwable ex){
        super(MESSAGE, ex);
    }

    public FileException(String currentMessage, Throwable ex){
        super(currentMessage, ex);
    }

    public FileException(String currentMessage){
        super(currentMessage);
    }
}
