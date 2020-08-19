package com.jalasoft.compress.controller.service;

import com.jalasoft.compress.controller.exception.FileException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 * This annotation is used for Spring to manage the Business logic.
 */
@Service
public class FileService {

    /**
     * Copy the file received from Postman to project folder.
     *
     * @param file           file required.
     * @param projectFolder  folder where the file will be copied.
     * @return               return a file.
     * @throws FileException raise a file exception.
     */
    public File store(MultipartFile file, String projectFolder) throws FileException{
        try {
            Path path = this.getFilePath(file.getOriginalFilename(), projectFolder);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return new File(path.toString());

        }catch (IOException ex){
            throw new FileException("File error", ex);
        }
    }

    private Path getFilePath(String fileName, String projectFolder) throws FileException{
       try {
           Files.createDirectories(Paths.get(projectFolder));
           return Paths.get(projectFolder + fileName);
       }catch (IOException ex){
           throw new FileException("Path error", ex);
       }
    }
    public String getZipPath(String compressedFolder,String fileName, String fileFormat){
        File file = new File(compressedFolder+fileName+"."+fileFormat);
        if (!file.exists()){
            return (file.getPath()).replace("\\","/");
        }else{
            return "Compressed file was not found";
        }
    }
}
