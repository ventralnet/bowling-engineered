package com.kirkley.bowling.components.frame;

import com.kirkley.bowling.components.roll.Throw;

/**
 * <pre>
 * The tenth frame is a 'special' frame in which the straight pin values are used for scoring.
 * A simple addition of all the throws consists of the contributing score to the game.
 * 
 * @author Matthew Kirkley
 */
public class TenthFrame implements Frame {

	private Throw firstThrow;
	private Throw secondThrow;
	private Throw thirdThrow;
		
	public TenthFrame(final Throw firstThrow, final Throw secondThrow, final Throw thirdThrow) {
		super();
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
		this.thirdThrow = thirdThrow;
	
	}
	
	@Override
	public int getScore() {
		return firstThrow.getPinCount() 
		        + secondThrow.getPinCount() 
		        + thirdThrow.getPinCount();
	}

	@Override
	public String toString() {
	    return "Tenth: " +getScore();
	}
}
