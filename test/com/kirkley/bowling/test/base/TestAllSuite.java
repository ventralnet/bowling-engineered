package com.kirkley.bowling.test.base;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.kirkley.bowling.component.roll.ThrowTestSuite;

public class TestAllSuite extends TestSuite {
    static public Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(ThrowTestSuite.suite());
        return suite;
    }
}
