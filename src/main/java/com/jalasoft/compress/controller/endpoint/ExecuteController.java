package com.jalasoft.compress.controller.endpoint;

import com.jalasoft.compress.model.ExecuteCommand;
import com.jalasoft.compress.model.parameter.CompressorParameter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/api/compress")

public class ExecuteController {

    @PostMapping
    public String execute(@RequestParam(value = "fileCompressor") String fileCompressor,
                          @RequestParam(value = "version") String version,
                          @RequestParam(value = "fileName") String fileName,
                          @RequestParam(value = "fileFormat") String fileFormat,
                          @RequestParam(value = "file") MultipartFile file) {

        //VALIDACIONES
        if(fileCompressor == null || fileCompressor.isEmpty()){
            return "Please provide a valid file compressor";
        }
        if (version.isEmpty()){
            return "Version was not provided";
        }
        if (fileName.isEmpty()){
            return "Operation cannot be processed, please provide a file name";
        }
        if (file == null || file.isEmpty()){
            return "Operation was processed,but compressed file/folder is empty";
        }
        //Fin validaciones.

        //---subir el archivo recibido al folder del proyecto---
        try {
            Files.createDirectories(Paths.get("compressProject/"));//Crea este folder en el proyecto.
            Path path = Paths.get("compressProject/" + file.getOriginalFilename()); //Donde voy a copiar el archivo
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            File fileToCompress = new File(path.toString());
            //---Fin subir el archivo recibido al folder del proyecto---

            //---Ejecutar comando---
            String winRarPath = "C:\\oop_project\\thirdParty\\compressor\\WinRAR\\";
            //String compressorFolder, String fileCompressor, String fileName,
            //                          String fileFormat, File file
            ExecuteCommand command = new ExecuteCommand();
            return command.execute(new CompressorParameter(winRarPath, fileCompressor, fileName, fileFormat, fileToCompress));

            //---Fin Ejecutar comando---
        }catch (IOException ex){
            return ex.getMessage();
        }
    }
}
