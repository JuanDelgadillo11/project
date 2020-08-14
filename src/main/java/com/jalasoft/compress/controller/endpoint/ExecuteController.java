package com.jalasoft.compress.controller.endpoint;

import com.jalasoft.compress.controller.component.Properties;
import com.jalasoft.compress.controller.request.RequestParam;
import com.jalasoft.compress.controller.response.ErrorResponse;
import com.jalasoft.compress.controller.response.OKResponse;
import com.jalasoft.compress.controller.response.Response;
import com.jalasoft.compress.model.ExecuteCommand;
import com.jalasoft.compress.model.command.ICommandBuilder;
import com.jalasoft.compress.model.command.WinrarCommand;
import com.jalasoft.compress.model.parameter.CompressorParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/api/compress")
public class ExecuteController {

    @Autowired
    private Properties properties;
    @PostMapping
    public ResponseEntity<Response> execute(RequestParam param) {
        //---subir el archivo recibido al folder del proyecto---
        try {
            param.validate(); //Valida los campos que me manda el Postman.
            Files.createDirectories(Paths.get(this.properties.getProjectFolder()));//Crea este folder en el proyecto.
            Path path = Paths.get(this.properties.getProjectFolder() + param.getFile().getOriginalFilename()); //Donde voy a copiar el archivo
            Files.copy(param.getFile().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            File fileToCompress = new File(path.toString());
            //---Fin subir el archivo recibido al folder del proyecto---

            // recupera el path donde esta mi winrar
            String winRarPath = this.properties.getWinrarPath();

            //CONSTRUIR COMANDO
            //usando mi InterfazIcommandBuilder puedo EN ESTE PUNTO DECIRLE QUE QUIERO CORRER UN WINZIP COMMAND O ZEVENZIPCOMMAND
            ICommandBuilder commandBuilder = new WinrarCommand(); // no deberia poder acceder a la clase concreta
                                                                  // Para arreglar esto es bueno crear otra clase q llegue a esta
            String command = commandBuilder.buildCommand(new CompressorParameter(winRarPath, param.getFileCompressor(),
                    param.getFileName(), param.getFileFormat(), fileToCompress));
            // FIN CONSTRUIR COMANDO

            /*
             * ---Ejecutar comando---
             * folder WinRar, winrar.exe, nombre del archixo,
             * extension (rar,zip,otro), archivo a comprimir del server
             * Folder CompressProject
             */
            /*
                String result= command.execute(new CompressorParameter(winRarPath, param.getFileCompressor(), param.getFileName(),
                param.getFileFormat(), fileToCompress));
            */
            ExecuteCommand executeCommand = new ExecuteCommand();
            String result = executeCommand.execute(command);
            //---Fin Ejecutar comando---

            // Retornar en formato JSON el resultado de ejecutar el comando (result)
            return ResponseEntity.ok().body(
                    new OKResponse("200", result, "0"));
                                //ResponseClass,OKresponse(message, PID)

        }catch (IOException ex){ //si el comando falla lanzar el siguiente error.
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("400", ex.getMessage()));
        }catch (Exception ex){//fileCompresor
            return ResponseEntity.badRequest().body(
                    new ErrorResponse("450", ex.getMessage()));
        }
    }
}

  /*
    * @RequestParam(value = "fileCompressor") String fileCompressor,
                          @RequestParam(value = "version") String version,
                          @RequestParam(value = "fileName") String fileName,
                          @RequestParam(value = "fileFormat") String fileFormat,
                          @RequestParam(value = "file") MultipartFile file
    * */


//        //VALIDACIONES movidas al Request Param
//        if(fileCompressor == null || fileCompressor.isEmpty()){
//            return "Please provide a valid file compressor";
//        }
//        if (version.isEmpty()){
//            return "Version was not provided";
//        }
//        if (fileName.isEmpty()){
//            return "Operation cannot be processed, please provide a file name";
//        }
//        if (file == null || file.isEmpty()){
//            return "Operation was processed,but compressed file/folder is empty";
//        }
//        //Fin validaciones.
