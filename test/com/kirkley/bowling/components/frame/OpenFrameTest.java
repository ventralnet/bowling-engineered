package com.kirkley.bowling.components.frame;

import com.kirkley.bowling.components.roll.Open;
import com.kirkley.bowling.test.base.BaseTest;

public class OpenFrameTest extends BaseTest {
    
    public void testGetScore() {
        /*
         * A open frame consists of two consecutive balls that don't result in all the pins being 
         * knocked down.
         */
        Open a = new Open(5);
        Open b = new Open(4);
        getLogger().debug(new OpenFrame(a, b).toString());
        assertEquals(9, new OpenFrame(a, b).getScore());
        assertEquals(9, new OpenFrame(b, a).getScore()); //commutative
        
        //A crappy bowler shouldn't break the system.
        a = new Open(0);
        b = new Open(0);
        assertEquals(0, new OpenFrame(a, b).getScore());
        assertEquals(0, new OpenFrame(b, a).getScore()); //commutative
        
        a = new Open(9);
        b = new Open(0);
        assertEquals(9, new OpenFrame(a, b).getScore());
        assertEquals(9, new OpenFrame(b, a).getScore()); //commutative
    }
    
}
