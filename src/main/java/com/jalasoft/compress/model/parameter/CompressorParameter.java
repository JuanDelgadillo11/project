package com.jalasoft.compress.model.parameter;

import java.io.File;

public class CompressorParameter {
    private String compressorFolder;
    private String fileCompressor;
    private String fileName;
    private String fileFormat;
    private File file;

    public CompressorParameter(String compressorFolder, String fileCompressor, String fileName, String fileFormat, File file) {
        this.compressorFolder = compressorFolder;
        this.fileCompressor = fileCompressor;
        this.fileName = fileName;
        this.fileFormat = fileFormat;
        this.file = file;
    }

    public String getCompressorFolder() {
        return compressorFolder;
    }

    public void setCompressorFolder(String compressorFolder) {
        this.compressorFolder = compressorFolder;
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

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    //metodo que valida los campos que me llegan del Postman y lo manejo con errores
    public void validate() throws Exception {
        throw new Exception("Invalid Parameters");
    }
}
