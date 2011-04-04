package com.kirkley.bowling.components.frame;

import com.kirkley.bowling.components.roll.Throw;
import com.kirkley.bowling.util.Constants;

public class SpareFrame implements Frame {

	/** The next ball that was rolled. */
	private Throw nextThrow;
	
	/**
	 * A requires the next throw to calculate the overall score of the frame.
	 * @param spareThrow
	 * @param nextThrow
	 */
	public SpareFrame(final Throw nextThrow) {
		this.nextThrow = nextThrow;
	}
	
	
	@Override
	public int getScore() {
		return Constants.TOTAL_PINS_PER_THROW + this.nextThrow.getPinCount();
	}

	@Override
	public String toString() {
	    return "Spare: ["+ getScore() +"]";
	}
	
}
