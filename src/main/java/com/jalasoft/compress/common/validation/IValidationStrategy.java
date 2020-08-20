package com.jalasoft.compress.common.validation;

import com.jalasoft.compress.common.exception.InvalidDataException;

public interface IValidationStrategy {
    void validate() throws InvalidDataException;
}
