package com.epam.task3.controller;


import com.epam.task3.controller.command.CommandName;
import com.epam.task3.service.CatalogService;
import com.epam.task3.service.exception.LogicException;
import com.epam.task3.service.factory.ServiceFactory;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

/**
 * Implements controller layer
 */
public class Controller {
    private final CommandProvider commandProvider = new CommandProvider();
    private static Controller instance;
    private final static String paramDelimeter = " ";

    private Controller(){
    }

    public static synchronized Controller getInstance() {
        if (instance == null) {
            instance = new  Controller();
        }
        return instance;
    }
    public void start() {
        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            CatalogService catalogService = serviceFactory.getCatalogServiceImpl();
            catalogService.start();
        } catch (LogicException e) {
            System.out.println("Invalid database connection");
        }
    }


    /**
     * split input String and give it to the command provider
     * @param request input String
     * @return response from executed command
     */
    public String execute(String request) {
        String commandName = request.substring(0, request.indexOf(paramDelimeter)).toUpperCase();
        String [] valuesInQuotes = StringUtils.substringsBetween(request , "\"", "\"");
        return commandProvider.getCommand(commandName).execute(valuesInQuotes, CommandName.valueOf(commandName).getTagCount());
    }
    public void finish() {
        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            CatalogService catalogService = serviceFactory.getCatalogServiceImpl();
            catalogService.finish();
        } catch (LogicException e) {
            System.out.println("Warning! Unexpected exit command call");
        }
    }

}
