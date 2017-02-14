package com.epam.task3.dao.impl;

import com.epam.task3.bean.Category;
import com.epam.task3.bean.News;
import com.epam.task3.dao.NewsDao;
import com.epam.task3.dao.exception.DAOException;
import com.epam.task3.dao.util.database.ConnectionPool;
import com.epam.task3.dao.util.database.exception.ConnectionPoolException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SQLNewsDao implements NewsDao {

    private static final String INSERT_NEWS =
            "INSERT INTO news (category, title, date) VALUES (?, ?, ?)";
    private Map<Integer, String> tagMapping = new HashMap<>();

    {
        tagMapping.put(1, "SELECT * FROM news WHERE category = ?");
        tagMapping.put(2, "SELECT * FROM news WHERE name = ?");
        tagMapping.put(3, "SELECT * FROM news WHERE title = ?");
    }


    @Override
    public void addNews(News news) throws DAOException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            ps = connection.prepareStatement(INSERT_NEWS);
            ps.setString(1, news.getCategory().toString());
            ps.setString(2, news.getItemName());
            ps.setString(3, news.getItemTitle());
            ps.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().closeConnection(connection, ps);
            }
        }
    }

    @Override
    public void start() throws DAOException {
        try {
            ConnectionPool.getInstance().initPoolData();
        } catch (ConnectionPoolException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public void finish() throws DAOException {
        try {
            ConnectionPool.getInstance().dispose();
        } catch (ConnectionPoolException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public ArrayList<News> getNewsByTag(String[] inputVariables, int tagCount) throws DAOException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = ConnectionPool.getInstance().takeConnection();
            ps = connection.prepareStatement(tagMapping.get(tagCount));
            ps.setString(1, inputVariables[0]);
            rs = ps.executeQuery();
            return convertResultSetToArrayList(rs);

        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(e);
        } finally {
            if (connection != null) {
                ConnectionPool.getInstance().closeConnection(connection, ps, rs);
            }
        }
    }

    private ArrayList<News> convertResultSetToArrayList(ResultSet rs) throws SQLException{
        ArrayList<News> newsList = new ArrayList<>();
        while (rs.next()) {
            News news = new News();
            news.setCategory(Category.valueOf(rs.getString(1)));
            news.setItemName(rs.getString(2));
            news.setItemTitle(rs.getString(3));
            newsList.add(news);
        }
        return newsList;
    }
}
