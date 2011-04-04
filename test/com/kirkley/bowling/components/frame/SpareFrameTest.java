package com.kirkley.bowling.components.frame;

import com.kirkley.bowling.components.roll.Open;
import com.kirkley.bowling.components.roll.Strike;
import com.kirkley.bowling.components.roll.Throw;
import com.kirkley.bowling.test.base.BaseTest;

public class SpareFrameTest extends BaseTest {
    public void testGetScore() {
        /*
         * A spare consists of an open frame plus 'the spare frame' where
         * the player knocked the rest of the balls down.  The score is the 
         * value of the next ball plus 10
         */
        Throw c = new Open(1); //Next throw
        SpareFrame frame= new SpareFrame(c);
        getLogger().debug(frame.toString());
        assertEquals(11, frame.getScore());

        c = new Strike(); //Next throw
        frame= new SpareFrame(c);
        getLogger().debug(frame);
        assertEquals(20,frame.getScore());
        
        c = new Open(0);
        frame= new SpareFrame(c);
        getLogger().debug(frame);
        assertEquals(10, frame .getScore());        
    }
}
