package com.kirkley.bowling.component.roll;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Test suite concerning testing of Throws
 * @author mkirkley
 */
public class ThrowTestSuite extends TestSuite {
    static public Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(OpenTest.class);
        suite.addTestSuite(SpareTest.class);
        suite.addTestSuite(StrikeTest.class);
        return suite;
    }
}
