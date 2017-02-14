package com.epam.task3.controller.command;

/**
 *  Defines behavior for any command input execution
 */
public interface Command {
    /**
     * handle request String and execute command according String array Value
     * @param inputVariables split input variables
     * @param tagCount
     * @return response
     */
    String execute(String[] inputVariables, int tagCount);
}