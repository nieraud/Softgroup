package com.softgroup.app.webAplicationJavaTask6.models.services;

import com.softgroup.app.webAplicationJavaTask6.models.factory.AbstractDaoFactory;
import com.softgroup.app.webAplicationJavaTask6.models.repositories.UserRepository;

/**
 * Created by inna on 09.03.17.
 */
public class UserDaoService extends AbstractDaoService implements UserRepository {
    public UserDaoService(AbstractDaoFactory daoFactory) {
        super(daoFactory);
    }


}
