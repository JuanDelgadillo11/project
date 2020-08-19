package com.jalasoft.compress.common.validation;

import com.jalasoft.compress.common.exception.InvalidDataException;
import org.springframework.web.multipart.MultipartFile;

public class MultipartFileValidation implements IValidationStrategy{
    private MultipartFile file;

    public MultipartFileValidation(MultipartFile file) {
        this.file = file;
    }

    @Override
    public void validate() throws InvalidDataException {
        if (this.file == null || this.file.isEmpty() || this.file.getOriginalFilename().contains("..")){
            throw new InvalidDataException("Invalid File received from Postman.");

        }
    }
}
