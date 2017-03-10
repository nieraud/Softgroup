package com.softgroup.app.webAplicationJavaTask6.models.factory;

import org.sql2o.Sql2o;

/**
 * Created by inna on 09.03.17.
 */
public interface DataSource {
    Sql2o getDataSource();
}
