package com.softgroup.app.webAplicationJavaTask6.models.services;

import com.softgroup.app.webAplicationJavaTask6.models.factory.AbstractDaoFactory;
import com.softgroup.app.webAplicationJavaTask6.models.repositories.GroupRepository;

/**
 * Created by inna on 10.03.17.
 */
public class GroupDaoService extends AbstractDaoService implements GroupRepository {
    public GroupDaoService(AbstractDaoFactory daoFactory) {
        super(daoFactory);
    }
}
