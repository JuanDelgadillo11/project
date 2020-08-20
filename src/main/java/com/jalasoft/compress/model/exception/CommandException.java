package com.jalasoft.compress.model.exception;

public class CommandException extends Exception {
    private static final String MESSAGE = "Malformed command";

    public CommandException() {
        super(MESSAGE);
    }

    public CommandException(Throwable ex){
        super(MESSAGE, ex);
    }

    public CommandException(String currentMessage, Throwable ex){
        super(currentMessage, ex);
    }

    public CommandException(String currentMessage){
        super(currentMessage);
    }
}
