package com.softgroup.app.webAplicationJavaTask6.utils.exceptions.handlers;

import lombok.Getter;
import org.sql2o.Sql2oException;
import spark.ExceptionHandler;
import spark.Request;
import spark.Response;
import spark.Route;

import java.text.ParseException;

/**
 * Created by inna on 09.03.17.
 */
public class Handler implements ExceptionHandler {

    @Override
    public void handle(Exception e, Request request, Response response) {
    }


    @Getter
    private static final Route notFound = (request, response) -> {
        response.type("application/json");
        return "{\"message\":\"Custom 404\"}";
    };

    @Getter
    private static final Route internalServerError = (request, response) -> {
        response.type("application/json");
        return "{\"message\":\"Custom 500 handling\"}";
    };


    @Getter
    private static final ExceptionHandler sql2oException = ((e, request, response) -> {

        Sql2oException exception = (Sql2oException) e;
        response.body("Помилка серверу. Інф: Sql2oException");
        response.type("application/json");
        response.status(500);

        System.out.println(exception.getMessage());
    });

    @Getter
    private static final ExceptionHandler parseException = ((e, request, response) -> {

        ParseException exception = (ParseException) e;
        response.body("Помилка серверу. Інф: ParseException");
        response.type("application/json");
        response.status(500);

        System.out.println(exception.getMessage());

    });


}
