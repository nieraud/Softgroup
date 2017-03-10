package com.softgroup.app.webAplicationJavaTask6.utils.exceptions;

import com.softgroup.app.webAplicationJavaTask6.utils.exceptions.handlers.Handler;
import org.sql2o.Sql2oException;

import static spark.Spark.exception;

/**
 * Created by inna on 09.03.17.
 */
public class ExceptionService implements ExceptionRouting {
    @Override
    public void init() {

        exception(Sql2oException.class, Handler.getSql2oException());

    }
}
