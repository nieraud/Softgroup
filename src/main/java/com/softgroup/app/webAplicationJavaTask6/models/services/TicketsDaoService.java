package com.softgroup.app.webAplicationJavaTask6.models.services;

import com.softgroup.app.webAplicationJavaTask6.models.factory.AbstractDaoFactory;
import com.softgroup.app.webAplicationJavaTask6.models.repositories.TicketsRepository;

/**
 * Created by inna on 09.03.17.
 */
public class TicketsDaoService extends AbstractDaoService implements TicketsRepository {
    public TicketsDaoService(AbstractDaoFactory daoFactory) {
        super(daoFactory);
    }
}
