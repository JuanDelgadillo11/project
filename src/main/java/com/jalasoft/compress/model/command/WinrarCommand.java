package com.jalasoft.compress.model.command;

import com.jalasoft.compress.model.parameter.CompressorParameter;

public class WinrarCommand implements ICommandBuilder{
    private static final String EXECUTABLE = ".exe";
    private static final String COMPRESSOR_PARAM = "a";
    private static final String DOT = ".";
    private static final String SPACE = " ";
    private static final String COMPRESSED_FILES_FOLDER = "C:\\test\\";

    public String buildCommand(CompressorParameter compressorParameter) throws Exception {
        compressorParameter.validate(); //validar los parametros

        StringBuilder command = new StringBuilder();
        command.append(compressorParameter.getCompressorFolder())
                .append(compressorParameter.getFileCompressor())
                .append(EXECUTABLE)// tengo que analizar si se queda o no
                .append(SPACE)
                .append(COMPRESSOR_PARAM)
                .append(SPACE)
                .append(COMPRESSED_FILES_FOLDER)
                .append(compressorParameter.getFileName())
                .append(DOT)
                .append(compressorParameter.getFileFormat())
                .append(SPACE)
                .append(compressorParameter.getFile().getParent());
        return command.toString();
    }
}
