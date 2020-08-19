package com.jalasoft.compress.controller.response;

public class OKResponse<T> extends Response {
    private String message;
    private String compressedFileFolderPath;

    public OKResponse(T status, String message, String compressedFileFolder) {
        super(status);
        this.message = message;
        this.compressedFileFolderPath = compressedFileFolder;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCompressedFileFolderPath() {
        return compressedFileFolderPath;
    }

    public void setCompressedFileFolderPath(String compressedFileFolderPath) {
        this.compressedFileFolderPath = compressedFileFolderPath;
    }
}
