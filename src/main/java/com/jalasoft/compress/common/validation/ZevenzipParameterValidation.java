package com.jalasoft.compress.common.validation;

import com.jalasoft.compress.common.exception.InvalidDataException;

import java.util.Arrays;
import java.util.List;

public class ZevenzipParameterValidation implements IValidationStrategy{
    private String parameter;
    private final static List<String> PARAMETER_LIST = Arrays.asList(
            "a"
    );

    public ZevenzipParameterValidation(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public void validate() throws InvalidDataException {
        if (!PARAMETER_LIST.contains(this.parameter)){
            throw new InvalidDataException("Invalid ZevenZip parameter to compress a file.");
        }

    }
}
