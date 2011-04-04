package com.kirkley.bowling.component.roll;

import junit.framework.TestCase;

import com.kirkley.bowling.components.roll.Open;
import com.kirkley.bowling.components.roll.Spare;

public class SpareTest extends TestCase{
    public void testGetPinCount() {
        /*
         * A spare is equal to knocking down whatever is left over from the first throw
         * so 10 - first throw
         */
        assertEquals(new Spare(new Open(1)).getPinCount(),10-1);
        assertEquals(new Spare(new Open(2)).getPinCount(),10-2);
        assertEquals(new Spare(new Open(3)).getPinCount(),10-3);
        assertEquals(new Spare(new Open(4)).getPinCount(),10-4);
        assertEquals(new Spare(new Open(5)).getPinCount(),10-5);
        assertEquals(new Spare(new Open(6)).getPinCount(),10-6);
        assertEquals(new Spare(new Open(7)).getPinCount(),10-7);        
        assertEquals(new Spare(new Open(8)).getPinCount(),10-8);
        assertEquals(new Spare(new Open(9)).getPinCount(),10-9);
    }
}
