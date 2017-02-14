package com.epam.task3.controller;

import com.epam.task3.controller.command.Command;
import com.epam.task3.controller.command.CommandName;
import com.epam.task3.controller.command.impl.*;

import java.util.HashMap;

/**
 * Provide access to any user command in this application
 */
public class CommandProvider {
    private final HashMap<CommandName, Command> repository = new HashMap<>();

    /**
     * create mapping between command and it command name
     */
    public CommandProvider() {
        repository.put(CommandName.ADDNEWS, new AddNews());
        repository.put(CommandName.CATEGORY, new FindByCategory());
        repository.put(CommandName.TITLE, new FindByTitle());
        repository.put(CommandName.NAME, new FindByName());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
    }

    /**
     * find command on its name
     * @param name first word in the console input
     * @return invoked command
     */
    public Command getCommand(String name) {
        CommandName commandName;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return repository.get(CommandName.WRONG_REQUEST);
        }
        return repository.get(commandName);
    }
}
