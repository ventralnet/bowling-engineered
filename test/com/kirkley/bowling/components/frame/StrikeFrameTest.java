package com.kirkley.bowling.components.frame;

import com.kirkley.bowling.components.roll.Open;
import com.kirkley.bowling.components.roll.Spare;
import com.kirkley.bowling.components.roll.Strike;
import com.kirkley.bowling.components.roll.Throw;
import com.kirkley.bowling.test.base.BaseTest;

public class StrikeFrameTest extends BaseTest {
    public void testGetScore() {
        /*
         * A strike consists of all pins being knocked down on one throw.
         * The score is the 
         * value of the next ball plus the next after that plus  10
         */
        Throw c = new Open(1); //Next throw
        Throw d = new Open(2); //Next Next throw
        StrikeFrame s = new StrikeFrame(c,d);
        getLogger().debug(s.toString());
        assertEquals(13, s.getScore());
        assertEquals(13, new StrikeFrame(d,c).getScore());//commutative

        c = new Strike(); //Next throw
        assertEquals(22, new StrikeFrame(c,d).getScore());
        assertEquals(22, new StrikeFrame(d,c).getScore());//commutative
        
        Open o = new Open(2);
        d = new Spare(o);
        assertEquals(20, new StrikeFrame(o,d).getScore());        
    }
}
