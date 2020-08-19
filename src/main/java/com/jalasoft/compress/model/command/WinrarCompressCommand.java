package com.jalasoft.compress.model.command;

import com.jalasoft.compress.common.exception.InvalidDataException;
import com.jalasoft.compress.model.exception.CommandException;
import com.jalasoft.compress.model.parameter.WinrarParameter;

public class WinrarCompressCommand implements ICommandBuilder<WinrarParameter>{
    private static final String EXECUTABLE = ".exe";
    private static final String COMPRESSOR_PARAM = "a";
    private static final String DOT = ".";
    private static final String SPACE = " ";
    @Override
    public String buildCommand(WinrarParameter winrarParameter) throws InvalidDataException, CommandException {
        winrarParameter.validate();
        StringBuilder command = new StringBuilder();
        command.append(winrarParameter.getCompressorFolder())
                .append(winrarParameter.getFileCompressor())
                .append(EXECUTABLE)
                .append(SPACE)
                .append(COMPRESSOR_PARAM)
                .append(SPACE)
                .append(winrarParameter.getCompressedfolder())
                .append(winrarParameter.getFileName())
                .append(DOT)
                .append(winrarParameter.getFileFormat())
                .append(SPACE)
                .append(winrarParameter.getFile().getParent());

        if(command.toString().isEmpty()){
            throw new CommandException();
        }
        return command.toString();
    }
}
