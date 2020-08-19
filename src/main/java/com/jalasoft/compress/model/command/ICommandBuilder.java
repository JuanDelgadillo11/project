package com.jalasoft.compress.model.command;

import com.jalasoft.compress.common.exception.InvalidDataException;
import com.jalasoft.compress.model.exception.CommandException;

public interface ICommandBuilder<T> {
    String buildCommand(T parameter) throws InvalidDataException, CommandException;
}
