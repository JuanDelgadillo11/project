package com.jalasoft.compress.common.validation;

import com.jalasoft.compress.common.exception.InvalidDataException;

import java.util.List;

public class ValidationContext {
    private List<IValidationStrategy> validationStrategy;

    public ValidationContext(List<IValidationStrategy> validationStrategy) {
        this.validationStrategy = validationStrategy;
    }

    public void validation() throws InvalidDataException {
        for (IValidationStrategy strategy : this.validationStrategy){
            strategy.validate();
        }

    }
}
