package com.jalasoft.compress.model.command;

import com.jalasoft.compress.common.exception.InvalidDataException;
import com.jalasoft.compress.model.exception.CommandException;
import com.jalasoft.compress.model.parameter.ZevenzipParameter;

public class ZevenzipCompressCommand implements ICommandBuilder<ZevenzipParameter>{
    private static final String EXECUTABLE = ".exe";
    private static final String DOT = ".";
    private static final String SPACE = " ";

    public String buildCommand(ZevenzipParameter zevenzipParameter) throws InvalidDataException, CommandException {
        if (zevenzipParameter == null){
            throw new InvalidDataException();
        }
        zevenzipParameter.validate();
        StringBuilder command = new StringBuilder();
        command.append(zevenzipParameter.getCompressorFolder())
                .append(zevenzipParameter.getFileCompressor())
                .append(EXECUTABLE)
                .append(SPACE)
                .append(zevenzipParameter.getParameter())
                .append(SPACE)
                .append(zevenzipParameter.getCompressedfolder())
                .append(zevenzipParameter.getFileName())
                .append(DOT)
                .append(zevenzipParameter.getFileFormat())
                .append(SPACE)
                .append(zevenzipParameter.getFile().getParent());

        if(command.toString().isEmpty()){
            throw new CommandException();
        }
        return command.toString();
    }
}
