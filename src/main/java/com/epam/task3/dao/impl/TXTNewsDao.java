package com.epam.task3.dao.impl;

import com.epam.task3.bean.Category;
import com.epam.task3.bean.News;
import com.epam.task3.dao.NewsDao;
import com.epam.task3.dao.exception.DAOException;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Aliaksei_Babak on 1/30/2017.
 */
public class TXTNewsDao implements NewsDao{

    private final String FILE = "newsStorage.txt";

    @Override
    public void addNews(News news) throws DAOException {
        File file = new File(System.getProperty("user.dir") + File.separator + FILE);
        try (BufferedWriter out = new BufferedWriter( new OutputStreamWriter( new FileOutputStream(file, true)))) {
            out.append("\"").append(String.valueOf(news.getCategory())).append("\" \"").append(news.getItemName()).append("\" \"").append(news.getItemTitle()).append("\"\n");
        } catch (IOException e) {
            throw new DAOException(e);
        }

    }

    @Override
    public void start() throws DAOException {

    }

    @Override
    public void finish() throws DAOException {

    }


    @Override
    public ArrayList<News> getNewsByTag(String[] inputVariables, int tagCount) throws DAOException {
        File file = new File(System.getProperty("user.dir") + File.separator + FILE);
        try (Scanner scanner = new Scanner(file)) {
            ArrayList<News> list = new ArrayList<>();
            while (scanner.hasNext()) {
                String news = scanner.nextLine();
                String[] valuesInQuotes = StringUtils.substringsBetween(news , "\"", "\"");
                if (StringUtils.containsIgnoreCase(valuesInQuotes[tagCount], inputVariables[0])) {
                    News newNews = new News();
                    newNews.setCategory(Category.valueOf(valuesInQuotes[0]));
                    newNews.setItemName(valuesInQuotes[1]);
                    newNews.setItemTitle(valuesInQuotes[2]);
                    list.add(newNews);
                }
            }
            return list;
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }
}
