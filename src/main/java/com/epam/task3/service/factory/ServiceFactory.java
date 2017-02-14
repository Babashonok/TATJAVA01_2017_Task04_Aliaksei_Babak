package com.epam.task3.service.factory;

import com.epam.task3.service.CatalogService;
import com.epam.task3.service.impl.CatalogServiceImpl;

/**
 * Pattern Factory for the Service layer realization
 */
public class ServiceFactory {

    private static ServiceFactory instance;

    public CatalogService getCatalogServiceImpl() {
        return catalogServiceImpl;
    }

    private final CatalogService catalogServiceImpl = new CatalogServiceImpl();

    private ServiceFactory() {}


    public static ServiceFactory getInstance() {
        if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
    }
}
