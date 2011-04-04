package com.kirkley.bowling.component.roll;

import com.kirkley.bowling.components.frame.TenthFrame;
import com.kirkley.bowling.components.roll.Open;
import com.kirkley.bowling.components.roll.Spare;
import com.kirkley.bowling.components.roll.Strike;
import com.kirkley.bowling.components.roll.Throw;
import com.kirkley.bowling.test.base.BaseTest;

public class TenthFrameTest extends BaseTest {
    public void testGetPinCount() {
        /*
         * A strike is ALWAYS equal to knocking down 10 pins
         */
        
        Throw a = new Open(4);
        Throw b = new Open(2);
        Throw c = new Spare((Open)b);
        TenthFrame frame = new TenthFrame(b,c,a);
        getLogger().debug(frame.toString());
        assertEquals(frame.getScore(),14);
        
        a = new Strike();
        b = new Strike();
        c = new Strike();
        assertEquals(new TenthFrame(a,b,c).getScore(),30);
        assertEquals(new TenthFrame(a,c,b).getScore(),30);
        assertEquals(new TenthFrame(b,a,c).getScore(),30);
    }
}
