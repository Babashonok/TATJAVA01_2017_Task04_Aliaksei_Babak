package com.epam.task3.dao.util.database;

import java.util.Locale;
import java.util.ResourceBundle;

public class DBResourceManager {

    private static DBResourceManager instance;

    private final String PROPERTIES_FILE_NAME = "db";

    private ResourceBundle bundle = ResourceBundle.getBundle(PROPERTIES_FILE_NAME, Locale.ENGLISH);

    private DBResourceManager() {}

    /**
     * Singleton implementation
     */
    public static DBResourceManager getInstance() {
        if (instance == null) {
            instance = new DBResourceManager();
        }

        return  instance;
    }

    public String getValue(String value) {
        return bundle.getString(value);
    }
}
