package com.jalasoft.compress.model.exception;

public class ExecuteException extends Exception {
    private static final String MESSAGE = "Error executing command";

    public ExecuteException() {
        super(MESSAGE);
    }

    public ExecuteException(Throwable ex){
        super(MESSAGE, ex);
    }

    public ExecuteException(String currentMessage, Throwable ex){
        super(currentMessage, ex);
    }

    public ExecuteException(String currentMessage){
        super(currentMessage);
    }
}
