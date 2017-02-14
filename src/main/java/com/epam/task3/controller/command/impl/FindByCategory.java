package com.epam.task3.controller.command.impl;

import com.epam.task3.bean.News;
import com.epam.task3.controller.command.Command;
import com.epam.task3.service.CatalogService;
import com.epam.task3.service.exception.LogicException;
import com.epam.task3.service.factory.ServiceFactory;

import java.util.ArrayList;

/**
 * Category command realization
 */
public class FindByCategory implements Command {
    /**
     * handle request String and execute command according String array Value
     *
     * @param inputVariables split input parameters
     * @param tagCount
     * @return response
     */
    public String execute(String[] inputVariables, int tagCount) {
        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            CatalogService catalogService = serviceFactory.getCatalogServiceImpl();
            return catalogService.searchByTag(inputVariables, tagCount);
        } catch (LogicException e) {
            return "Error! This search cannot be done";
        }
    }
}
