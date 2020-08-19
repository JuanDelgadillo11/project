package com.jalasoft.compress.model.parameter;

import com.jalasoft.compress.common.exception.InvalidDataException;

import java.io.File;

public abstract class Parameter {
    protected File file;
    public Parameter(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public abstract void validate()throws InvalidDataException;
}
