package com.jalasoft.compress.controller.response;

public class ErrorResponse extends Response{
    private String error;

    public ErrorResponse(String status, String error) {
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
