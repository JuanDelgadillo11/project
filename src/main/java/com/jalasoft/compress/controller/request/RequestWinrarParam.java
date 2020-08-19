package com.jalasoft.compress.controller.request;

import com.jalasoft.compress.common.exception.InvalidDataException;
import com.jalasoft.compress.common.validation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequestWinrarParam {
    private String fileCompressor;
    private String version;
    private String  fileName;
    private String fileFormat;
    private MultipartFile file;

    private final static List<String> WINRAR_VERSION_LIST = Arrays.asList(
            "4",
            "5"
    );

    public RequestWinrarParam(String fileCompressor, String version, String fileName, String fileFormat, MultipartFile file) {
        this.fileCompressor = fileCompressor;
        this.version = version;
        this.fileName = fileName;
        this.fileFormat = fileFormat;
        this.file = file;
    }

    public String getFileCompressor() {
        return fileCompressor;
    }

    public void setFileCompressor(String fileCompressor) {
        this.fileCompressor = fileCompressor;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void validate() throws InvalidDataException {
        List<IValidationStrategy> validationStrategies = new ArrayList<>();
        validationStrategies.add(new NotNullOrEmptyValidation("fileCompressor", this.fileCompressor));
        validationStrategies.add(new NotNullOrEmptyValidation("version", this.version));
        validationStrategies.add(new NotNullOrEmptyValidation("fileName", this.fileName));
        validationStrategies.add(new NotNullOrEmptyValidation("fileFormat", this.fileFormat));
        validationStrategies.add(new MultipartFileValidation(this.file));
        validationStrategies.add(new FileCompressorValidation(this.fileCompressor));
        validationStrategies.add(new WinrarVersionValidation(this.version));

        ValidationContext context = new ValidationContext(validationStrategies);
        context.validation();
    }
}
