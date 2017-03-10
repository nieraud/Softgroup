package com.softgroup.app.webAplicationJavaTask6.models.services;

import com.softgroup.app.webAplicationJavaTask6.models.factory.AbstractDaoFactory;
import com.softgroup.app.webAplicationJavaTask6.models.repositories.IssueRepository;

/**
 * Created by inna on 09.03.17.
 */
public class IssueDaoService extends AbstractDaoService implements IssueRepository {
    public IssueDaoService(AbstractDaoFactory daoFactory) {
        super(daoFactory);
    }
}
