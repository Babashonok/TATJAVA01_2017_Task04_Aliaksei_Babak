package com.epam.task3.dao.util.database.exception;

public class ConnectionPoolException extends Exception {

    public ConnectionPoolException() {
        super();
    }

    public ConnectionPoolException(String message) {
        super(message);
    }

    public ConnectionPoolException(String message, Exception e) {
        super(message, e);
    }

    public ConnectionPoolException(Exception e) {
        super(e);
    }
}