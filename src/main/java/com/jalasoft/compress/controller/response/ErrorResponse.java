package com.jalasoft.compress.controller.response;

public class ErrorResponse<T> extends Response{
    private String error;

    public ErrorResponse(T status, String error) {
        super(status);
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
