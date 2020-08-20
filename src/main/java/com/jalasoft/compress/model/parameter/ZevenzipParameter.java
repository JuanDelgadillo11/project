package com.jalasoft.compress.model.parameter;

import com.jalasoft.compress.common.exception.InvalidDataException;
import com.jalasoft.compress.common.validation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ZevenzipParameter extends Parameter{
    private String compressorFolder;
    private String compressedfolder;
    private String fileCompressor;
    private String parameter;
    private String fileName;
    private String fileFormat;

        public ZevenzipParameter(String compressorFolder, String compressedfolder, String fileCompressor,
                                 String parameter,String fileName, String fileFormat, File file) {
            super(file);
            this.compressorFolder = compressorFolder;
            this.compressedfolder = compressedfolder;
            this.fileCompressor = fileCompressor;
            this.parameter = parameter;
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

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
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
        validationStrategies.add(new NotNullOrEmptyValidation("parameter",this.parameter));
        validationStrategies.add(new CompressorFolderValidation(this.compressorFolder));
        validationStrategies.add(new FileValidation(this.file));
        validationStrategies.add(new ZevenzipParameterValidation(this.parameter));

        ValidationContext context = new ValidationContext(validationStrategies);
        context.validation();
    }
}
