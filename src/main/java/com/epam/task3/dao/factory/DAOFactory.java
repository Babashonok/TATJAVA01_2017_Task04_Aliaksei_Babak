package com.epam.task3.dao.factory;

import com.epam.task3.dao.NewsDao;
import com.epam.task3.dao.impl.SQLNewsDao;
import com.epam.task3.dao.impl.TXTNewsDao;

/**
 * Pattern Factory for the DAO layer realization
 */
public class DAOFactory {

    private static DAOFactory instance;

    private final NewsDao txtNewsDao = new TXTNewsDao();
    private final NewsDao sqlNewsDao = new SQLNewsDao();

    private DAOFactory() {}

    public static DAOFactory getInstance() {
        if (instance == null) {
            instance = new DAOFactory();
        }
        return instance;
    }

    public NewsDao getTXTNewsDAO() {
        return txtNewsDao;
    }

    public NewsDao getSqlNewsDao() {
        return sqlNewsDao;
    }
}
