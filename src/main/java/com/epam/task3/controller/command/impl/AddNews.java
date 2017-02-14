package com.epam.task3.controller.command.impl;

import com.epam.task3.bean.Category;
import com.epam.task3.bean.News;
import com.epam.task3.controller.command.Command;
import com.epam.task3.service.CatalogService;
import com.epam.task3.service.exception.LogicException;
import com.epam.task3.service.factory.ServiceFactory;

/**
 * AddNews command realization
 */
public class AddNews implements Command {

    /**
     * handle request String and execute command according String array Value
     *
     * @param inputVariables split input parameters
     * @param tagCount
     * @return response
     */
    public String execute(String[] inputVariables, int tagCount)  {
        News news = createNews(inputVariables);
        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            CatalogService catalogService = serviceFactory.getCatalogServiceImpl();
            catalogService.addNews(news);
        } catch (LogicException e) {
            return "Invalid News adding";
        }
        return "News Successfully added";
    }

    private News createNews(String [] request) {
        News news = new News();
        news.setCategory(Category.valueOf(request[0].toUpperCase()));
        news.setItemName(request[1]);
        news.setItemTitle(request[2]);
        return news;
    }
}
