package com.softgroup.app.webAplicationJavaTask6.controllers.groupCtrl;

import com.google.gson.Gson;
import com.softgroup.app.webAplicationJavaTask6.models.factory.DaoServiceFactory;
import com.softgroup.app.webAplicationJavaTask6.models.repositories.GroupRepository;
import lombok.Getter;
import spark.Route;

/**
 * Created by inna on 10.03.17.
 */
public class GroupCtrl {
    @Getter
    private static GroupRepository groupDaoService = DaoServiceFactory.getGroupService();
    private Gson gson = new Gson();

    @Getter
    private static Route allGroups = (request, response) -> {
        return response;
    };

    @Getter
    private static Route groupById = (request, response) -> {
        return response;
    };

    @Getter
    private static Route addGroup = (request, response) -> {
        return response;
    };

    @Getter
    private static Route updateGroup = (request, response) -> {
        return response;
    };

    @Getter
    private static Route addNewUserToGroup = (request, response) -> {
        return response;
    };

    @Getter
    private static Route removeUserFromGroup = (request, response) -> {
        return response;
    };
}
