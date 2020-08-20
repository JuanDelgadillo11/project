package com.jalasoft.compress.common.validation;

import com.jalasoft.compress.common.exception.InvalidDataException;

import java.io.File;

public class FileValidation implements IValidationStrategy{
    private File file;

    public FileValidation(File file) {
        this.file = file;
    }

    @Override
    public void validate() throws InvalidDataException {
        if (this.file == null || !this.file.isFile() || this.file.isHidden()){
            throw new InvalidDataException("Invalid file to compress");
        }
    }
}
