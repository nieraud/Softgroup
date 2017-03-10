package com.softgroup.app.webAplicationJavaTask6.controllers.issueCtrl;

import com.google.gson.Gson;
import com.softgroup.app.webAplicationJavaTask6.models.factory.DaoServiceFactory;
import com.softgroup.app.webAplicationJavaTask6.models.repositories.IssueRepository;
import lombok.Getter;
import spark.Route;

/**
 * Created by inna on 09.03.17.
 */
public class IssueCtrl {

    @Getter
    private IssueRepository issumeDaoService = DaoServiceFactory.getIssueService();
    private Gson gson = new Gson();

    @Getter
    private static Route issues = (request, response) -> {
        return response;
    };

    @Getter
    private static Route issueById = (request, response) -> {
        return response;
    };

    @Getter
    private static Route addNewIssue = (request, response) -> {
        return response;
    };

    @Getter
    private static Route updateIssue = (request, response) -> {
        return response;
    };

    @Getter
    private static Route commentById = (request, response) -> {
        return response;
    };

    @Getter
    private static Route addNewComment = (request, response) -> {
        return response;
    };
}
