package com.softgroup.app.webAplicationJavaTask6.utils.routing;

import com.softgroup.app.webAplicationJavaTask6.controllers.groupCtrl.GroupCtrl;
import com.softgroup.app.webAplicationJavaTask6.controllers.issueCtrl.IssueCtrl;
import com.softgroup.app.webAplicationJavaTask6.controllers.ticketsCtrl.TicketsCtrl;
import com.softgroup.app.webAplicationJavaTask6.controllers.userCtrl.UserCtrl;

import static spark.Spark.*;

/**
 * Created by inna on 09.03.17.
 */
public class Router implements Routing{
    @Override
    public void init() {

        get("/auth", UserCtrl.getAccessToken());

        post("/signup", UserCtrl.getSignUp());
        post("/signin", UserCtrl.getSignIn());
        get("/signout", UserCtrl.getSignOut());

        get("/users", UserCtrl.getAllUsers());
        get("/users/:id", UserCtrl.getUserById());
        post("/post", UserCtrl.getAddUser());
        put("/users", UserCtrl.getUpdateUser());

        get("/issues", IssueCtrl.getIssues());
        get("/issues/:id", IssueCtrl.getIssueById());
        post("/issues", IssueCtrl.getAddNewIssue());
        put("/issues/:id", IssueCtrl.getUpdateIssue());
        get("/issues/:id/comments/:idC", IssueCtrl.getCommentById());
        post("/issues/:id/comments/", IssueCtrl.getAddNewComment());

        get("/tickets", TicketsCtrl.getAllTickets());
        get("/tickets/:id", TicketsCtrl.getTicketsById());
        post("tickets", TicketsCtrl.getAddTicket());
        put("/tickets/:id", TicketsCtrl.getUpdateTicket());
        get("tickets/:id/comment/:idC", TicketsCtrl.getCommentById());
        post("/tickets/:id/comments", TicketsCtrl.getAddComment());

        get("/groups", GroupCtrl.getAllGroups());
        get("/groups/:id", GroupCtrl.getGroupById());
        post("/groups", GroupCtrl.getAddGroup());
        put("/groups/:id", GroupCtrl.getUpdateGroup());
        post("/groups/:id/user_add", GroupCtrl.getAddNewUserToGroup());
        post("/groups/:id/user_remove", GroupCtrl.getRemoveUserFromGroup());


    }




}
