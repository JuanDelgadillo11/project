package com.jalasoft.compress.model.parameter;

import com.jalasoft.compress.common.exception.InvalidDataException;
import com.jalasoft.compress.common.validation.CompressorFolderValidation;
import com.jalasoft.compress.common.validation.IValidationStrategy;
import com.jalasoft.compress.common.validation.NotNullOrEmptyValidation;
import com.jalasoft.compress.common.validation.ValidationContext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WinzipParameter extends Parameter{
    private String compressorFolder;
    private String compressedfolder;
    private String fileCompressor;
    private String fileName;
    private String fileFormat;

    public WinzipParameter(String compressorFolder, String compressedfolder, String fileCompressor,
                           String fileName, String fileFormat, File file) {
        super(file);
        this.compressorFolder = compressorFolder;
        this.compressedfolder = compressedfolder;
        this.fileCompressor = fileCompressor;
        this.fileName = fileName;
        this.fileFormat = fileFormat;
    }

    public String getCompressorFolder() {
        return compressorFolder;
    }

    public void setCompressorFolder(String compressorFolder) {
        this.compressorFolder = compressorFolder;
    }

    public String getCompressedfolder() {
        return compressedfolder;
    }

    public void setCompressedfolder(String compressedfolder) {
        this.compressedfolder = compressedfolder;
    }

    public String getFileCompressor() {
        return fileCompressor;
    }

    public void setFileCompressor(String fileCompressor) {
        this.fileCompressor = fileCompressor;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public void validate() throws InvalidDataException {
        List<IValidationStrategy> validationStrategies = new ArrayList<>();
        validationStrategies.add(new NotNullOrEmptyValidation("compressorFolder",this.compressorFolder));
        validationStrategies.add(new CompressorFolderValidation(this.compressorFolder));

        ValidationContext context = new ValidationContext(validationStrategies);
        context.validation();
    }
}
