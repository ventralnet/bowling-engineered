package com.kirkley.bowling.util;

import java.util.ArrayList;

import com.kirkley.bowling.components.frame.Frame;
import com.kirkley.bowling.components.frame.OpenFrame;
import com.kirkley.bowling.components.frame.SpareFrame;
import com.kirkley.bowling.components.frame.StrikeFrame;
import com.kirkley.bowling.components.frame.TenthFrame;
import com.kirkley.bowling.components.roll.Open;
import com.kirkley.bowling.components.roll.Spare;
import com.kirkley.bowling.components.roll.Strike;
import com.kirkley.bowling.components.roll.Throw;
import com.kirkley.bowling.test.base.BaseTest;

public class GameUtilsTest extends BaseTest {
    public void testConstructThrows() {
        //All open
        String rawString = "01-00-00-00-90-00-00-00-00-000".replaceAll("-", "");
        ArrayList<Throw> tosses = GameUtils.constructThrows(rawString);
        for (Throw toss : tosses) {
            assertSameType(toss, Open.class);
        }

        //Stike out
        rawString = "X-X-X-X-X-X-X-X-X-XXX".replaceAll("-", "");
        tosses = GameUtils.constructThrows(rawString);
        for (Throw toss : tosses) {
            assertSameType(toss, Strike.class);
        }

        //Spare and opens
        rawString = "0/-0/-0/-0/-0/-0/-0/-0/-0/-0/".replaceAll("-", "");
        tosses = GameUtils.constructThrows(rawString);
        int i = 1;
        for (Throw toss : tosses) {
            if (i++ % 2 == 0) {
                assertSameType(toss, Spare.class);
            } else {
                assertSameType(toss, Open.class);
            }

        }
    }
    
    public void testConstructFrames() {
        //All open frames
        String rawString = "01-00-00-00-90-00-00-00-00-000".replaceAll("-", "");
        ArrayList<Throw> tosses = GameUtils.constructThrows(rawString); 
        ArrayList<Frame> frames = GameUtils.constructFrames(tosses);
        int i = 0;
        for (i = 0 ; i < frames.size()-1; i++) {
            assertSameType(frames.get(i),OpenFrame.class);
        }
        assertSameType(frames.get(i),TenthFrame.class); 
        
        //All strike frames
        rawString = "X-X-X-X-X-X-X-X-X-XXX".replaceAll("-", "");
        tosses = GameUtils.constructThrows(rawString); 
        frames = GameUtils.constructFrames(tosses);
        i = 0;
        for (i = 0 ; i < frames.size()-1; i++) {
            assertSameType(frames.get(i),StrikeFrame.class);
        }
        assertSameType(frames.get(i),TenthFrame.class);
        
        //Alternating spare, then open
        rawString = "0/-X-0/-X-0/-X-0/-X-0/-0/0".replaceAll("-", "");
        tosses = GameUtils.constructThrows(rawString); 
        frames = GameUtils.constructFrames(tosses);
        i = 0;
        for (i = 0 ; i < frames.size()-1; i++) {
            if ((i+1) % 2 == 0) {
                assertSameType(frames.get(i),StrikeFrame.class);
            } else {
                assertSameType(frames.get(i),SpareFrame.class);
            }
        }
        assertSameType(frames.get(i),TenthFrame.class);
        rawString = "X-0/-X-0/-X-0/-X-0/-X-0/0".replaceAll("-", "");
        tosses = GameUtils.constructThrows(rawString); 
        frames = GameUtils.constructFrames(tosses);
        i = 0;
        for (i = 0 ; i < frames.size()-1; i++) {
            if ((i+1) % 2 == 0) {
                assertSameType(frames.get(i),SpareFrame.class);
            } else {
                assertSameType(frames.get(i),StrikeFrame.class);
            }
        }
        assertSameType(frames.get(i),TenthFrame.class);
        
        rawString = "X-0/-X-0/-X-0/-X-0/-X-00".replaceAll("-", "");
        tosses = GameUtils.constructThrows(rawString); 
        frames = GameUtils.constructFrames(tosses);
        i = 0;
        for (i = 0 ; i < frames.size()-1; i++) {
            if ((i+1) % 2 == 0) {
                assertSameType(frames.get(i),SpareFrame.class);
            } else {
                assertSameType(frames.get(i),StrikeFrame.class);
            }
        }
        //even though we specified no 10th frame info, this should still work
        assertSameType(frames.get(i),TenthFrame.class);
        
    }
}
