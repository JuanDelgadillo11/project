package com.jalasoft.compress.common.validation;

import com.jalasoft.compress.common.exception.InvalidDataException;

public class NotNullOrEmptyValidation implements IValidationStrategy {
    private String field;
    private String value;

    public NotNullOrEmptyValidation(String field, String value){
        this.field = field;
        this.value = value;
    }

    @Override
    public void validate() throws InvalidDataException {
        if(this.value == null || this.value.trim().isEmpty()){
            throw new InvalidDataException("Invalid data on field = " + this.field) ;
        }
    }
}
