package com.epam.task3.controller.command.impl;

import com.epam.task3.controller.command.Command;

/**
 * Mock command for any invalid input
 */
public class WrongRequest implements Command {

    /**
     *
     * @param request split input parameters
     * @param tagCount
     * @return error message after invoking
     */
    public String execute(String[] request, int tagCount) {
        return "Error! Invalid command input.";
    }
}
