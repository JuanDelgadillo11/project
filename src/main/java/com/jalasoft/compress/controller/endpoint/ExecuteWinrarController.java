package com.jalasoft.compress.controller.endpoint;

import com.jalasoft.compress.common.exception.InvalidDataException;
import com.jalasoft.compress.controller.component.WinrarProperties;
import com.jalasoft.compress.controller.exception.FileException;
import com.jalasoft.compress.controller.exception.PropertyException;
import com.jalasoft.compress.controller.request.RequestWinrarParam;
import com.jalasoft.compress.controller.response.ErrorResponse;
import com.jalasoft.compress.controller.response.OKResponse;
import com.jalasoft.compress.controller.response.Response;
import com.jalasoft.compress.controller.service.FileService;
import com.jalasoft.compress.model.ExecuteCommand;
import com.jalasoft.compress.model.command.ICommandBuilder;
import com.jalasoft.compress.model.command.WinrarCompressCommand;
import com.jalasoft.compress.model.exception.CommandException;
import com.jalasoft.compress.model.exception.ExecuteException;
import com.jalasoft.compress.model.parameter.WinrarParameter;
import com.jalasoft.compress.model.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@RestController
@RequestMapping("/api/compress")
public class ExecuteWinrarController {

    @Autowired
    private WinrarProperties winrarProperties;

    @Autowired
    private FileService fileService;

    @PostMapping("/compress-winrar")
    public ResponseEntity<Response> execute(RequestWinrarParam param) {

        try {
            param.validate();
            File winRarFile = this.fileService.store(param.getFile(),this.winrarProperties.getProjectFolder());
            String zipfolder= this.fileService.getZipPath(this.winrarProperties.getCompressedfolder(),
                    param.getFileName(),param.getFileFormat());

            String winrarPath = this.winrarProperties.getLanguageFolder(param.getVersion());
            String winrarCompressedFolder= this.winrarProperties.getCompressedfolder();

            ICommandBuilder<WinrarParameter> commandBuilder = new WinrarCompressCommand();
            String command = commandBuilder.buildCommand(new WinrarParameter(winrarPath,winrarCompressedFolder,
                    param.getFileCompressor(), param.getFileName(), param.getFileFormat(), winRarFile));

            ExecuteCommand executeCommand = new ExecuteCommand();
            Result result = executeCommand.execute(command);

            return ResponseEntity.ok().body(new OKResponse<Integer>(HttpServletResponse.SC_OK,
                    result.getResultConsole(),zipfolder));

        }catch (InvalidDataException | FileException | PropertyException ex ){
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage()));

        }catch (CommandException | ExecuteException ex){
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage()));
        }
    }
}