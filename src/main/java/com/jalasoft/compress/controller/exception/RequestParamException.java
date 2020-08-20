package com.jalasoft.compress.controller.exception;

public class RequestParamException extends Exception{
    private static final String MESSAGE = "Invalid Parameters";

    public RequestParamException() {
        super(MESSAGE);
    }

    public RequestParamException(Throwable ex){
        super(MESSAGE, ex);
    }

    public RequestParamException(String currentMessage, Throwable ex){
        super(currentMessage, ex);
    }

    public RequestParamException(String currentMessage){
        super(currentMessage);
    }
}
