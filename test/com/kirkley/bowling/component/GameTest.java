package com.kirkley.bowling.component;

import java.util.HashMap;

import com.kirkley.bowling.components.GameFactory;
import com.kirkley.bowling.test.base.BaseTest;

public class GameTest extends BaseTest {
   
    public void testGetScore() {
        
        for (String currRawString : bowlingStringToScore.keySet()) {
            getLogger().debug("Testing input string of: [" + currRawString + "]");
            assertEquals(GameFactory.getGame(currRawString).getScore(),bowlingStringToScore.get(currRawString).intValue());
        }
        
        
    }

    private static HashMap<String,Integer> bowlingStringToScore = new HashMap<String,Integer>();
    static {
        bowlingStringToScore.put("00-00-00-00-00-00-00-00-00-000", 0);
        bowlingStringToScore.put("45-18-90-09-54-27-36-63-90-81", 90); //all open frames of 9
        bowlingStringToScore.put("45-18-90-09-54-27-36-63-90-810", 90); //same as before, but extra zero on 10th
        bowlingStringToScore.put("0/-0/-0/-0/-0/-0/-0/-0/-0/-0/X", 110); //Spare then open frame and spare strike as the last balls
        bowlingStringToScore.put("0/-X-0/-X-0/-X-0/-X-0/-XXX", 210); //Spare then strike
        bowlingStringToScore.put("X-X-X-X-X-X-X-X-X-9/X", 279); //messed up last frame
        bowlingStringToScore.put("X-X-X-X-X-X-X-X-X-XXX", 300); //strike out
        bowlingStringToScore.put("00-X-00-X-00-X-00-X-00-XXX", 70); //open the strike
        bowlingStringToScore.put("X-20-X-20-X-90-X-20-X-11", 84); //Open 10th frame
        bowlingStringToScore.put("X-20-X-20-X-90-X-20-X-1/6", 106); //10th spare open frame
        bowlingStringToScore.put("00-00-00-00-00-00-00-00-00-0X0", 10); //10th spare open frame
        bowlingStringToScore.put("0/-0/-0/-0/-0/-0/-0/-0/-0/-0/0", 100); //spare out
        bowlingStringToScore.put("00-00-00-00-00-00-00-00-00-XXX", 30); //only scoring is done in last frame
        
        
    }
    
}
