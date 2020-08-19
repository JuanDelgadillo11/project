package com.jalasoft.compress.common.validation;

import com.jalasoft.compress.common.exception.InvalidDataException;

import java.util.Arrays;
import java.util.List;

public class ZevenzipVersionValidation implements IValidationStrategy {
    private String version;
    private final static List<String> VERSION_LIST = Arrays.asList(
            "18",
            "19"
    );

    public ZevenzipVersionValidation(String version) {
        this.version = version;
    }

    @Override
    public void validate() throws InvalidDataException {
        if (!VERSION_LIST.contains(this.version)){
            throw new InvalidDataException("Invalid ZevenZip file compressor version.");
        }

    }
}
