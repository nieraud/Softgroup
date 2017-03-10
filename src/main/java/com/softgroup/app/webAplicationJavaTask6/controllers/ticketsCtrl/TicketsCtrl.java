package com.softgroup.app.webAplicationJavaTask6.controllers.ticketsCtrl;

import com.google.gson.Gson;
import com.softgroup.app.webAplicationJavaTask6.models.factory.DaoServiceFactory;
import com.softgroup.app.webAplicationJavaTask6.models.repositories.TicketsRepository;
import lombok.Getter;
import spark.Route;

/**
 * Created by inna on 09.03.17.
 */
public class TicketsCtrl {

    @Getter
    private TicketsRepository commentDaoService = DaoServiceFactory.getCommentService();
    private Gson gson = new Gson();

    @Getter
    private static Route allTickets = (request, response) -> {
        return response;
    };

    @Getter
    private static Route ticketsById = (request, response) -> {
      return response;
    };

    @Getter
    private static Route addTicket = (request, response) -> {
        return response;
    };

    @Getter
    private static Route updateTicket = (request, response) -> {
        return response;
    };

    @Getter
    private static Route commentById = (request, response) -> {
        return response;
    };

    @Getter
    private static Route addComment = (request, response) -> {
        return response;
    };





}
