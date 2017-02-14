package com.epam.task3.dao;

import com.epam.task3.bean.News;
import com.epam.task3.dao.exception.DAOException;

import java.util.ArrayList;

/**
 * describes behavior of the NewsDAO Entity
 */
public interface NewsDao {

    /**
     * to start conversation with database
     * @throws DAOException
     */
    void start() throws DAOException;

    /**
     * to finish conversation with database
     * @throws DAOException
     */
    void finish() throws DAOException;
    /**
     * write information about new news in the file
     * @param news self-created news
     * @throws DAOException
     */
    void addNews(News news) throws DAOException;

    /**
     * read information from the file
     * @param inputVariables
     * @param tagCount tag to find correct information
     * @return arraylist of found news
     * @throws DAOException
     */
    ArrayList<News> getNewsByTag(String[] inputVariables, int tagCount) throws DAOException;

}
