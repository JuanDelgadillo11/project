package com.jalasoft.compress.model.command;

import com.jalasoft.compress.common.exception.InvalidDataException;
import com.jalasoft.compress.model.exception.CommandException;
import com.jalasoft.compress.model.parameter.WinrarParameter;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class WinrarCompressCommandTest {

    private final static String winrarFolder4 = "C:/oop_project/thirdParty/compressor/WinRAR/version4/";
    private final static String winrarFolder5 = "C:/oop_project/thirdParty/compressor/WinRAR/version5/";
    private final static String compressedFolder = "C:/test/";
    private final static String winrarFile = "src/test/resources/winrarFolder/file1.txt";
    private final static String fileCompressor = "winrar";
    private final static String fileName = "test";
    private final static String fileFormat = "zip";

    @Test
    public void buildCommandWinrar5() throws InvalidDataException, CommandException {
        WinrarParameter winrarParameter = new WinrarParameter(winrarFolder5, compressedFolder, fileCompressor,
                fileName, fileFormat, new File(winrarFile));
        WinrarCompressCommand command = new WinrarCompressCommand();
        String result = command.buildCommand(winrarParameter);
        System.out.println(result);
        String expected = "C:/oop_project/thirdParty/compressor/WinRAR/version5/winrar.exe a C:/test/test.zip src\\" +
                "test\\resources\\winrarFolder";
        assertEquals("valid command", expected, result);
    }

    @Test
    public void buildCommandWinrar4() throws InvalidDataException, CommandException {
        WinrarParameter winrarParameter = new WinrarParameter(winrarFolder4, compressedFolder, fileCompressor, fileName,
                fileFormat, new File(winrarFile));
        WinrarCompressCommand command = new WinrarCompressCommand();
        String result = command.buildCommand(winrarParameter);
        System.out.println(result);
        String expected = "C:/oop_project/thirdParty/compressor/WinRAR/version4/winrar.exe a C:/test/test.zip src\\" +
                "test\\resources\\winrarFolder";
        assertEquals("valid command", expected, result);
    }
}
