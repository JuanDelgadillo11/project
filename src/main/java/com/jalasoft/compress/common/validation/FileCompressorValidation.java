package com.jalasoft.compress.common.validation;

import com.jalasoft.compress.common.exception.InvalidDataException;

import java.util.Arrays;
import java.util.List;

public class FileCompressorValidation implements IValidationStrategy{
    private String fileCompressor;
    private final static List<String> COMPRESSOR_LIST = Arrays.asList(
            "7z",
            "winrar",
            "winzip"
    );

    public FileCompressorValidation(String fileCompressor) {
        this.fileCompressor = fileCompressor;
    }

    @Override
    public void validate() throws InvalidDataException {
        if (!COMPRESSOR_LIST.contains(this.fileCompressor)){
            throw new InvalidDataException("Invalid file compressor");
        }

    }
}
