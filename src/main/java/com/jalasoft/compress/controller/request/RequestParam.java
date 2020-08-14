package com.jalasoft.compress.controller.request;

import org.springframework.web.multipart.MultipartFile;

public class RequestParam {
    private String fileCompressor;
    private String version;
    private String  fileName;
    private String fileFormat;
    private MultipartFile file;

    public RequestParam(String fileCompressor, String version, String fileName, String fileFormat, MultipartFile file) {
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

    public void validate() throws Exception{
        //VALIDACIONES
        if(fileCompressor == null || fileCompressor.isEmpty()){
            throw new Exception("Please provide a valid file compressor") ;
        }
        if (version.isEmpty()){ //(MEJORAR LA VALIDACION DE VERSIONES)
            throw new Exception( "Version was not provided");
        }
        if (fileName.isEmpty()){
            throw new Exception( "Operation cannot be processed, please provide a file name");
        }
        if (file == null || file.isEmpty()){
            throw new Exception( "Operation was processed,but compressed file/folder is empty");
        }
        //Fin validaciones.
    }
}
    /*
    * @RequestParam(value = "fileCompressor") String fileCompressor,
                          @RequestParam(value = "version") String version,
                          @RequestParam(value = "fileName") String fileName,
                          @RequestParam(value = "fileFormat") String fileFormat,
                          @RequestParam(value = "file") MultipartFile file
    * */
