package com.softgroup.app.webAplicationJavaTask6.models.services;

import com.softgroup.app.webAplicationJavaTask6.models.factory.AbstractDaoFactory;
import org.sql2o.Sql2o;

/**
 * Created by inna on 09.03.17.
 */
public class AbstractDaoService{
    protected AbstractDaoFactory daoFactory;

    public AbstractDaoService(AbstractDaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
}
