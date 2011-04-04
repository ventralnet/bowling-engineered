package com.kirkley.bowling.components;

import java.util.ArrayList;

import com.kirkley.bowling.components.frame.Frame;
import com.kirkley.bowling.components.roll.Throw;
import com.kirkley.bowling.util.Constants;
import com.kirkley.bowling.util.GameUtils;

/**
 * Factory to construct a Game instance. A Game instance knows how to calculate
 * a score giving a valid 10 pin bowling game.
 * @author Matthew Kirkley
 */
public class GameFactory {

    /** static utility class, no instantiation. */
    private GameFactory(){}
    
    public static Game getGame(final String stringGameRepresentation) {
        // Remove the - chars as according to the input strings, they don't really serve a purpose
        String rawFrames = stringGameRepresentation.replaceAll(Constants.DELIMITER, "");

        ArrayList<Throw> rolls = GameUtils.constructThrows(rawFrames);

        ArrayList<Frame> frames = GameUtils.constructFrames(rolls);
        
        return new Game(frames);
    }


    

    


}
