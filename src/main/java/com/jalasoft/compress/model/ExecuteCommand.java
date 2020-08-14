package com.jalasoft.compress.model;

import com.jalasoft.compress.model.parameter.CompressorParameter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecuteCommand {

    public String execute(String command) throws Exception {

        //ejecutar comando
        try {
            //como ejecutar un comando- Me crea un proceso para ejecutar un comando
            ProcessBuilder builder = new ProcessBuilder("cmd", "/c", "\"" + command + "\"");
            builder.redirectErrorStream(true);

            Process process = builder.start();
            process.waitFor();
            //ANTES DEL CAMBIO
            return command;

            // CAMBIO
//            InputStreamReader streamReader = new InputStreamReader(process.getInputStream());
//            BufferedReader reader = new BufferedReader(streamReader);
//
//            StringBuilder result = new StringBuilder();
//            while (reader.ready()) {
//                result.append((char) reader.read());
//            }
//
//            return result.toString();

        }catch (IOException ex){
            return ex.getMessage();
        }catch (InterruptedException ex){
            return ex.getMessage();
        }
    }
}
//C:\oop_project\thirdParty\compressor\WinRAR\WinRAR.exe a C:\oop_project\files\compressed\Info.rar
// && C:\oop_project\files\tocompress\file1.txt
//private static final String FILE_COMPRESSOR = "WinRAR.exe";

//String winRarPath = "C:\\oop_project\\thirdParty\\compressor\\WinRAR\\";
//String fileName = "C:\\test\\file1";
//String fileFormat = "rar";
//String fileToCompress = "C:\\oop_project\\files\\tocompress\\file1.txt";
// String command = winRarPath + "WinRAR.exe a "+ fileName + "." + fileFormat + " " + fileToCompress;
