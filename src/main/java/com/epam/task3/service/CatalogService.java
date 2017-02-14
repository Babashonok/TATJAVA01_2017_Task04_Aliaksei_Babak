package com.epam.task3.service;

import com.epam.task3.bean.News;
import com.epam.task3.service.exception.LogicException;

import java.util.ArrayList;

/**
 * describes behavior of the CatalogService Entity
 */
public interface CatalogService {

    void start() throws LogicException;
    /**
     * add news to the file
     * @param news self-created news
     * @throws LogicException
     */
    void addNews(News news) throws LogicException;

    /**
     * find all search suited entities
     * @param inputVariables splitted user input
     * @param tagCount
     * @return string representation of the news list
     * @throws LogicException
     */
    String searchByTag(String[] inputVariables, int tagCount) throws LogicException;
    void finish() throws LogicException;

}
