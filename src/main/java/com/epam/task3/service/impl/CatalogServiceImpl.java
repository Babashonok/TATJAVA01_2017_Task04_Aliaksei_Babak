package com.epam.task3.service.impl;

import com.epam.task3.bean.News;
import com.epam.task3.dao.NewsDao;
import com.epam.task3.dao.exception.DAOException;
import com.epam.task3.dao.factory.DAOFactory;
import com.epam.task3.service.CatalogService;
import com.epam.task3.service.decorator.ResponseBuilder;
import com.epam.task3.service.exception.LogicException;

import java.util.ArrayList;

/**
 * Created by Aliaksei_Babak on 1/30/2017.
 */
public class CatalogServiceImpl implements CatalogService{


    @Override
    public void start() throws LogicException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            NewsDao newsDao = daoFactory.getSqlNewsDao();
            newsDao.start();
        } catch (DAOException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void addNews(News news) throws LogicException {
        if (news == null || news.getCategory() == null || news.getItemName() == null || news.getItemTitle() == null) {
            throw new LogicException("News can't be added. Some of the parameters nas null values");
        }
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            NewsDao newsDao = daoFactory.getSqlNewsDao();
            newsDao.addNews(news);
        } catch (DAOException e) {
            throw new LogicException(e);
        }

    }

    /**
     * Method returns list of news, found by definite title in request
     *
     * @param inputVariables
     * @param tagCount
     */
    @Override
    public String searchByTag(String[] inputVariables, int tagCount) throws LogicException {
        if (inputVariables.length != 1) {
            throw new LogicException("Error! You should find by one parameter in quotes");
        }
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            NewsDao newsDao = daoFactory.getSqlNewsDao();
            ArrayList<News> newsList = newsDao.getNewsByTag(inputVariables, tagCount);
            return ResponseBuilder.decorateResponseAboutFoundNews(newsList);
        } catch (DAOException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void finish() throws LogicException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            NewsDao newsDao = daoFactory.getSqlNewsDao();
            newsDao.finish();
        } catch (DAOException e) {
            throw new LogicException(e);
        }
    }

}
