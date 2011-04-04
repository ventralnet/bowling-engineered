package com.kirkley.bowling.component.roll;

import junit.framework.TestCase;

import com.kirkley.bowling.components.roll.Strike;

public class StrikeTest extends TestCase{
    public void testGetPinCount() {
        /*
         * A strike is ALWAYS equal to knocking down 10 pins
         */
        assertEquals(new Strike().getPinCount(),10);
    }
}
