package com.kirkley.bowling.components.frame;

import com.kirkley.bowling.components.roll.Open;

public class OpenFrame implements Frame {

	/** The value of the first throw. */
	private Open firstThrow;

	/** The value of the second throw. */
	private Open secondThrow;

	/**
	 * An open frame means neither a strike or spare was rolled. The total 
	 * contributing value to the score is the addition of the first ball 
	 * thrown and the second ball thrown. Unless if this is the last frame
	 * @param firstThrow
	 * @param secondThrow
	 */
	public OpenFrame(final Open firstThrow, final Open secondThrow) {
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}

	@Override
	public int getScore() {
		return firstThrow.getPinCount() + secondThrow.getPinCount();
	}
	
	@Override
	public String toString() {
	    return "Open: [" +getScore() +"]";	    
	}

}
