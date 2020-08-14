package com.jalasoft.compress.controller.response;

public class OKResponse extends Response {
    private String message;
    private String pid;

    public OKResponse(String status, String message, String pid) {
        super(status);
        this.message = message;
        this.pid = pid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
