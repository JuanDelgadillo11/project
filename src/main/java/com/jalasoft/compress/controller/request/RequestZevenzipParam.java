package com.jalasoft.compress.controller.request;

import com.jalasoft.compress.common.exception.InvalidDataException;
import com.jalasoft.compress.common.validation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RequestZevenzipParam {
    private String fileCompressor;
    private String parameter;
    private String version;
    private String  fileName;
    private String fileFormat;
    private MultipartFile file;

    private final static List<String> ZEVENZIP_VERSION_LIST = Arrays.asList(
            "18",
            "19"
    );

    public RequestZevenzipParam(String fileCompressor, String parameter, String version,
                                String fileName, String fileFormat, MultipartFile file) {
        this.fileCompressor = fileCompressor;
        this.parameter = parameter;
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

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
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
          validationStrategies.add(new NotNullOrEmptyValidation("parameter", this.parameter));
          validationStrategies.add(new NotNullOrEmptyValidation("fileName", this.fileName));
          validationStrategies.add(new NotNullOrEmptyValidation("fileFormat", this.fileFormat));
          validationStrategies.add(new MultipartFileValidation(this.file));
          validationStrategies.add(new FileCompressorValidation(this.fileCompressor));
          validationStrategies.add(new ZevenzipVersionValidation(this.version));
          validationStrategies.add(new ZevenzipParameterValidation(this.parameter));

          ValidationContext context = new ValidationContext(validationStrategies);
          context.validation();
    }
}
