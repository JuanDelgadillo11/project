package com.jalasoft.compress.controller.response;
// Lo defino como abstracto porque no voy a necesitar instanciar esta clase
public abstract class Response {
    private String status;

    public Response(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
