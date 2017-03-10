package com.softgroup.app.webAplicationJavaTask6.utils.validator;

/**
 * Created by inna on 09.03.17.
 */
public class ObjectConverterValidator {

    public static void nullChecker(Object object) throws Exception {
        if (object == null) throw new NullPointerException();
    }
}
