package com.jalasoft.compress.model;

import com.jalasoft.compress.model.parameter.CompressorParameter;

import java.io.File;
import java.io.IOException;

public class ExecuteCommand {

    //C:\oop_project\thirdParty\compressor\WinRAR\WinRAR.exe a C:\oop_project\files\compressed\Info.rar
    // && C:\oop_project\files\tocompress\file1.txt
    //private static final String FILE_COMPRESSOR = "WinRAR.exe";
    private static final String EXECUTABLE = ".exe";
    private static final String COMPRESSOR_PARAM = "a";
    private static final String DOT = ".";
    private static final String SPACE = " ";
    private static final String COMPRESSED_FILES_FOLDER = "C:\\test\\";

    public String execute(CompressorParameter compressorParameter) {
        //String winRarPath = "C:\\oop_project\\thirdParty\\compressor\\WinRAR\\";
        //String fileName = "C:\\test\\file1";
        //String fileFormat = "rar";
        //String fileToCompress = "C:\\oop_project\\files\\tocompress\\file1.txt";
       // String command = winRarPath + "WinRAR.exe a "+ fileName + "." + fileFormat + " " + fileToCompress;
        //compressorParameter.validate();

        StringBuilder command = new StringBuilder();
        command.append(compressorParameter.getCompressorFolder())
                .append(compressorParameter.getFileCompressor())
                .append(EXECUTABLE)
                .append(SPACE)
                .append(COMPRESSOR_PARAM)
                .append(SPACE)
                .append(COMPRESSED_FILES_FOLDER)
                .append(compressorParameter.getFileName())
                .append(DOT)
                .append(compressorParameter.getFileFormat())
                .append(SPACE)
                .append(compressorParameter.getFile().getParent());
        //ejecutar comando
        try {
            //como ejecutar un comando- Me crea un proceso para ejecutar un comando
            ProcessBuilder builder = new ProcessBuilder("cmd", "/c", "\"" + command.toString() + "\"");
            builder.redirectErrorStream(true);

            Process process = builder.start();
            process.waitFor();

        }catch (IOException ex){
            return ex.getMessage();
        }catch (InterruptedException ex){
            return ex.getMessage();
        }
        return command.toString();
    }
}
