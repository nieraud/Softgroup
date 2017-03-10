package com.softgroup.app.webAplicationJavaTask6.models.factory;

import com.softgroup.app.webAplicationJavaTask6.models.repositories.GroupRepository;
import com.softgroup.app.webAplicationJavaTask6.models.repositories.TicketsRepository;
import com.softgroup.app.webAplicationJavaTask6.models.repositories.IssueRepository;
import com.softgroup.app.webAplicationJavaTask6.models.repositories.UserRepository;
import com.softgroup.app.webAplicationJavaTask6.models.services.GroupDaoService;
import com.softgroup.app.webAplicationJavaTask6.models.services.TicketsDaoService;
import com.softgroup.app.webAplicationJavaTask6.models.services.IssueDaoService;
import com.softgroup.app.webAplicationJavaTask6.models.services.UserDaoService;

/**
 * Created by inna on 09.03.17.
 */
public abstract class AbstractDaoFactory implements DataSource {

    public AbstractDaoFactory() {
    }

    static class DAO_SERVICE {

        static final UserRepository USER_REPOSITORY =
                new UserDaoService(getInstance());
        static final TicketsRepository TICKETS_REPOSITORY =
                new TicketsDaoService(getInstance());
        static final IssueRepository ISSUE_REPOSITORY =
                new IssueDaoService(getInstance());
        static final GroupRepository GROUP_REPOSITORY =
                new GroupDaoService(getInstance());


    }

    public static AbstractDaoFactory getInstance() {
        return PgDataSource.getInstance();
    }

}
