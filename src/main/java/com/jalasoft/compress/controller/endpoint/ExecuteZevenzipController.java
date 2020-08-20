package com.jalasoft.compress.controller.endpoint;

import com.jalasoft.compress.common.exception.InvalidDataException;
import com.jalasoft.compress.controller.component.ZevenzipProperties;
import com.jalasoft.compress.controller.exception.FileException;
import com.jalasoft.compress.controller.exception.PropertyException;
import com.jalasoft.compress.controller.request.RequestZevenzipParam;
import com.jalasoft.compress.controller.response.ErrorResponse;
import com.jalasoft.compress.controller.response.OKResponse;
import com.jalasoft.compress.controller.response.Response;
import com.jalasoft.compress.controller.service.FileService;
import com.jalasoft.compress.model.ExecuteCommand;
import com.jalasoft.compress.model.command.ICommandBuilder;
import com.jalasoft.compress.model.command.ZevenzipCompressCommand;
import com.jalasoft.compress.model.exception.CommandException;
import com.jalasoft.compress.model.exception.ExecuteException;
import com.jalasoft.compress.model.parameter.ZevenzipParameter;
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
public class ExecuteZevenzipController {

    @Autowired
    private ZevenzipProperties zevenzipProperties;

    @Autowired
    private FileService fileService;

    @PostMapping("/compress-zevenzip")
    public ResponseEntity<Response> execute(RequestZevenzipParam param) {

        try {
            param.validate();

            File zevenzipFile = this.fileService.store(param.getFile(),this.zevenzipProperties.getProjectFolder());
            String zipfolder= this.fileService.getZipPath(this.zevenzipProperties.getCompressedfolder(),
                                                          param.getFileName(),param.getFileFormat());
            String zevenzipPath = this.zevenzipProperties.getLanguageFolder(param.getVersion());
            String zevenzipCompressedFolder= this.zevenzipProperties.getCompressedfolder();

            ICommandBuilder<ZevenzipParameter> commandBuilder = new ZevenzipCompressCommand();
            String command = commandBuilder.buildCommand(new ZevenzipParameter(zevenzipPath,zevenzipCompressedFolder,
                    param.getFileCompressor(),param.getParameter(), param.getFileName(), param.getFileFormat(),
                    zevenzipFile));

            ExecuteCommand executeCommand = new ExecuteCommand();
            Result result = executeCommand.execute(command);

            return ResponseEntity.ok().body(
                    new OKResponse<Integer>(HttpServletResponse.SC_OK, result.getResultConsole(),zipfolder));

        }catch (InvalidDataException | FileException | PropertyException ex ){
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage()));

        }catch (CommandException | ExecuteException ex){
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage()));
        }
    }
}
