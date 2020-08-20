package com.jalasoft.compress.model.command;

import com.jalasoft.compress.common.exception.InvalidDataException;
import com.jalasoft.compress.model.exception.CommandException;
import com.jalasoft.compress.model.parameter.ZevenzipParameter;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ZevenzipCompressCommandTest {
    private final static String zevenzipFolder18 = "C:/oop_project/thirdParty/compressor/7-Zip/version18/";
    private final static String zevenzipFolder19 = "C:/oop_project/thirdParty/compressor/7-Zip/version19/";
    private final static String zevenzipFolder18Invalid = "C:/oop_project/thirdParty/compressor/7-Zip123/version18/";
    private final static String compressedFolder = "C:/test/";
    private final static String zevenzipFile = "src/test/resources/zevenzipFolder/file1.txt";
    private final static String fileCompressor = "7z";
    private final static String parameter = "a";
    private final static String fileName = "test";
    private final static String fileFormat = "zip";

    @Test
    public void buildCommandZevenzip18() throws InvalidDataException, CommandException {
        ZevenzipParameter zevenzipParameter = new ZevenzipParameter(zevenzipFolder18, compressedFolder,
                fileCompressor, parameter, fileName, fileFormat, new File(zevenzipFile));
        ZevenzipCompressCommand command = new ZevenzipCompressCommand();
        String result = command.buildCommand(zevenzipParameter);
        System.out.println(result);
        String expected = "C:/oop_project/thirdParty/compressor/7-Zip/version18/7z.exe" +
                " a C:/test/test.zip src\\test\\resources\\zevenzipFolder";
        assertEquals("valid command", expected, result);
    }

    @Test
    public void buildCommandZevenzip19() throws InvalidDataException, CommandException {
        ZevenzipParameter zevenzipParameter = new ZevenzipParameter(zevenzipFolder19, compressedFolder,
                fileCompressor, parameter, fileName, fileFormat, new File(zevenzipFile));
        ZevenzipCompressCommand command = new ZevenzipCompressCommand();
        String result = command.buildCommand(zevenzipParameter);
        System.out.println(result);
        String expected = "C:/oop_project/thirdParty/compressor/7-Zip/version19/7z.exe" +
                " a C:/test/test.zip src\\test\\resources\\zevenzipFolder";
        assertEquals("valid command", expected, result);
    }

    @Test(expected = InvalidDataException.class)
    public void buildCommandZevenZipNullParameter() throws InvalidDataException, CommandException{
        ZevenzipCompressCommand zevenzipCompressCommand = new ZevenzipCompressCommand();
        zevenzipCompressCommand.buildCommand(null);
    }

    @Test(expected = InvalidDataException.class)
    public void buildCommandInvalidFolder() throws InvalidDataException, CommandException{
        ZevenzipParameter zevenzipParameter = new ZevenzipParameter(zevenzipFolder18Invalid, compressedFolder,
                fileCompressor, parameter, fileName,
                fileFormat, new File(zevenzipFile));
        ZevenzipCompressCommand command = new ZevenzipCompressCommand();
        command.buildCommand(zevenzipParameter);
    }

    @Test(expected = InvalidDataException.class)
    public void buildCommandZevenzipParameter() throws InvalidDataException, CommandException{
        ZevenzipCompressCommand command = new ZevenzipCompressCommand();
        command.buildCommand(new ZevenzipParameter(null,null, null,null,
                null,null, null));
    }
}
