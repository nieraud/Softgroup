package com.softgroup.app.webAplicationJavaTask6.controllers.userCtrl;

import com.google.gson.Gson;
import com.softgroup.app.webAplicationJavaTask6.models.factory.DaoServiceFactory;
import com.softgroup.app.webAplicationJavaTask6.models.repositories.UserRepository;
import lombok.Getter;
import spark.Route;

/**
 * Created by inna on 09.03.17.
 */
public class UserCtrl {
    @Getter
    private UserRepository userDaoService = DaoServiceFactory.getUserService();
    private Gson gson = new Gson();

    @Getter
    private static Route accessToken = (request, response) -> {
            // access token for a 20 minutes;
        return response;
    };

    @Getter
    private static Route signUp = (request, response) -> {
        // access token for a 20 minutes;
        return response;
    };

    @Getter
    private static Route signIn = (request, response) -> {
        return response;
    };

    @Getter
    private static Route signOut = (request, response) -> {
        return response;
    };

    @Getter
    private static Route allUsers = (request, response) -> {
        return response;
    };

    @Getter
    private static Route userById = (request, response) -> {
        return response;
    };

    @Getter
    private static Route addUser = (request, response) -> {
        return response;
    };

    @Getter
    private static Route updateUser = (request, response) -> {
        return response;
    };




}
