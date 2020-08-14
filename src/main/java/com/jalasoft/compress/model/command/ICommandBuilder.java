package com.jalasoft.compress.model.command;

import com.jalasoft.compress.model.parameter.CompressorParameter;

public interface ICommandBuilder {
    String buildCommand(CompressorParameter compressorParameter) throws Exception;
}
