package com.kirkley.bowling.util;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.kirkley.bowling.components.frame.Frame;
import com.kirkley.bowling.components.frame.OpenFrame;
import com.kirkley.bowling.components.frame.SpareFrame;
import com.kirkley.bowling.components.frame.StrikeFrame;
import com.kirkley.bowling.components.frame.TenthFrame;
import com.kirkley.bowling.components.roll.Open;
import com.kirkley.bowling.components.roll.Spare;
import com.kirkley.bowling.components.roll.Strike;
import com.kirkley.bowling.components.roll.Throw;

/**
 * Helper methods used for game scoring type things
 * @author Matthew Kirkley
 */
public class GameUtils {

    private static Logger log = Logger.getLogger(GameUtils.class);
    
    /**
     * Takes a raw input string representing a bowling game. The raw string representation
     * contains up to 13 characters that are either a number 0-9 or an X or / for strike
     * and spare respectively.
     * @param rawFrames
     * @return list of throws built from rawFrames raw string.
     */
    public static ArrayList<Throw> constructThrows(final String rawFrames) {
        ArrayList<Throw> rolls = new ArrayList<Throw>();
        Throw lastThrow = null;
        for (int i = 0; i < rawFrames.length(); i++) {
            char currChar = rawFrames.charAt(i);
            Throw currThrow = null;
            if (currChar == Constants.SPARE_RAW_INDICATOR) {
                currThrow = new Spare((Open) lastThrow);
            } else if (currChar == Constants.STRIKE_RAW_INDICATOR) {
                currThrow = new Strike();
            } else {
                currThrow = new Open(Character.digit(currChar, 10));
            }
            rolls.add(currThrow);
            lastThrow = currThrow;
        }   
        return rolls;
    }
    
    /**
     * From the list of rolls passed, the frames that make up a game of 
     * 10 pin bowling is constructed.
     * @param rolls
     * @return list of frames.
     */
    public static ArrayList<Frame> constructFrames(ArrayList<Throw> rolls) {
        log.debug("Enter constructFrames(ArrayList<Throw> rolls)()");
        
        ArrayList<Frame> frames = new ArrayList<Frame>(10);

        Throw lastOpenThrow = null;
        int throwNum = 0;
        for (; frames.size() < 9; throwNum++) {
            log.debug("throwNum = " +throwNum + ", Frame size= " + frames.size());
            Throw currThrow = rolls.get(throwNum);
            if (currThrow instanceof Strike) {
                log.debug("constructed StrikeFrame");
                frames.add(new StrikeFrame(getNext(rolls, throwNum, 1), getNext(rolls, throwNum, 2)));
            } else if (currThrow instanceof Spare) {
                log.debug("constructed SpareFrame");
                frames.add(new SpareFrame(getNext(rolls, throwNum, 1)));
                lastOpenThrow = null;
            } else if (lastOpenThrow != null) {
                log.debug("constructed OpenFrame");
                frames.add(new OpenFrame((Open) lastOpenThrow, (Open) currThrow));
                lastOpenThrow = null;
            } else {
                log.debug("detected open throw on start of new frame");
                lastOpenThrow = currThrow;
            }
        }
       
        frames.add(new TenthFrame(rolls.get(throwNum), 
                                  rolls.get(++throwNum), 
                                  rolls.size() > ++throwNum ? rolls.get(throwNum) : new Open(0))); //third throw in 10th frame is not required
        
        return frames;
    }
    
    /*
     * Helper method that looks ahead in the rolls ArrayList
     */
    private static Throw getNext(ArrayList<Throw> rolls, int startIndex, int readAhead) {
        return rolls.get(startIndex + readAhead);
    }
    
}
