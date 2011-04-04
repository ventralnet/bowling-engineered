package com.kirkley.bowling.test.base;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

/**
 * Base test that all unit tests in this project
 * will extend.
 * @author Matthew Kirkley
 */
public abstract class BaseTest extends TestCase{

    private Logger logger = Logger.getLogger(getClass());
    
    public Logger getLogger() {
        return logger;
    }
    
    
    /**
     * Asserts that arg0 is in the same type
     * arg1
     * @param arg0
     * @param arg1
     * @return true or false
     */
    public static void assertSameType(Object arg0, Class<?> arg1) {
        assertEquals(arg0.getClass(),arg1);
    }
}
