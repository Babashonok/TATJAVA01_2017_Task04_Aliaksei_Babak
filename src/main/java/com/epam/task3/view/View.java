package com.epam.task3.view;


import com.epam.task3.controller.Controller;

/**
 * Implements view layer
 */
public class View {
    private static View instance;


    public static View getInstance() {
        if (instance == null) {
            instance = new  View();
        }
        return instance;
    }

    public String request(String request) {
        Controller controller = Controller.getInstance();
        return controller.execute(request);
    }
}
