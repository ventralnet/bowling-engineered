package com.kirkley.bowling.components;

import java.util.ArrayList;

import com.kirkley.bowling.components.frame.Frame;

/**
 * A representation of a game of 10-pin bowling. The rules of 10-pin
 * bowling are as follows.
 * 
 * <ul>
 * 	<li>One game of bowling is made up of ten frames.</li>
 * 	<li>In each frame, the bowler has two throws to knock down all the pins.</li>
 * 		Possible results for a frame:
 * 	<ul>
 * 		<li>Strike (‘X’): the bowler knocks down all 10 pins on the first throw.
 * 		The frame is over early. The score for the frame is 10 plus the total pins knocked down on
 * 		the next two throws.</li>
 * 		<li>Spare (‘/’): the bowler knocks down all 10 pins using two throws.
 * 		The score for the frame is 10 plus the number of pins knocked down on the next throw.</li>
 * 		<li>Open frame: the bowler knocks down less than 10 pins with his two throws. The score for
 * 		the frame is the total number of pins knocked down.
 * 		The game score is the total of all frame scores.</li>
 * 	</ul>
 * 	<li>Special rules for the 10th frame:
 * 	<ul>
 * 		<li>A strike in the tenth frame gives the bowler two bonus throws, to fill out the scoring
 * 		formula for the last frame.</li>
 * 		<li>A spare in the tenth frame gives the bowler one bonus throw, to fill out the scoring
 * 		formula for the last frame.</li>
 * 		<li>These throws count as part of the 10th frame.</li>
 * 		<li>The process does not repeat – for example, knocking down all 10 pins on a bonus throw
 * 		does not provide any additional bonus throws.</li>
 * 	</ul>
 * </ul>
 * @author Matthew Kirkley
 */
public class Game {
	
    /** The 10 frames of the game. */
    private ArrayList<Frame> frames = new ArrayList<Frame>(10);
    
	/** 
	 * The default constructor is default access. Construct Game instances through 
	 * the <code>com.kirkley.bowling.components.GameFactory</code>
	 */
	Game(final ArrayList<Frame> frames){
	    //copy frames, prevent modifications outside of Game class.
	    for (Frame curr : frames) {
	        this.frames.add(curr);
	    }
	}
	
	/** 
	 * Returns the full score of the bowling game, adding up all
	 * the frames taking into account strikes and spares.
	 * @return the game score.
	 */
	public int getScore() {
	    int score = 0;
	    for (Frame curr : frames) {
	        score += curr.getScore();
	    }
	    return score;
	}
}
