package com.jalasoft.compress.common.validation;


import com.jalasoft.compress.common.exception.InvalidDataException;

import java.io.File;

public class CompressorFolderValidation implements IValidationStrategy {
    private String compressorFolder;

    public CompressorFolderValidation(String compressorFolder) {
        this.compressorFolder = compressorFolder;
    }

    @Override
    public void validate() throws InvalidDataException {
        File compressorFolderPath = new File(this.compressorFolder);
        if (!compressorFolderPath.isDirectory() || compressorFolderPath.isHidden()){
            throw new InvalidDataException("Invalid compressorFolder");
        }
    }
}
