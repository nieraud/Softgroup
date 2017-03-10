package com.softgroup.app.webAplicationJavaTask6;

import com.softgroup.app.webAplicationJavaTask6.utils.exceptions.ExceptionRouting;
import com.softgroup.app.webAplicationJavaTask6.utils.exceptions.ExceptionService;
import com.softgroup.app.webAplicationJavaTask6.utils.routing.Router;
import com.softgroup.app.webAplicationJavaTask6.utils.routing.Routing;

/**
 * Created by inna on 09.03.17.
 */
class StarterFacade {
    static void start(){

        initRoutingService();
        initExceptionService();

    }

    private static void initExceptionService() {
    ExceptionRouting service = new ExceptionService();
        service.init();
    }

    private static void initRoutingService(){
        Routing service = new Router();
        service.init();
    }
}
