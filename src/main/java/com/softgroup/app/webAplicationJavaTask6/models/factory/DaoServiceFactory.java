package com.softgroup.app.webAplicationJavaTask6.models.factory;

import com.softgroup.app.webAplicationJavaTask6.models.repositories.GroupRepository;
import com.softgroup.app.webAplicationJavaTask6.models.repositories.TicketsRepository;
import com.softgroup.app.webAplicationJavaTask6.models.repositories.IssueRepository;
import com.softgroup.app.webAplicationJavaTask6.models.repositories.UserRepository;
import org.sql2o.Sql2o;

/**
 * Created by inna on 09.03.17.
 */
public class DaoServiceFactory extends AbstractDaoFactory {
    @Override
    public Sql2o getDataSource() {
        return AbstractDaoFactory.getInstance().getDataSource();
    }

    public static UserRepository getUserService() {
        return DAO_SERVICE.USER_REPOSITORY;
    }

    public static TicketsRepository getCommentService() {
        return DAO_SERVICE.TICKETS_REPOSITORY;
    }

    public static IssueRepository getIssueService() {
        return DAO_SERVICE.ISSUE_REPOSITORY;
    }

    public static GroupRepository getGroupService(){
        return DAO_SERVICE.GROUP_REPOSITORY;
    }
}
