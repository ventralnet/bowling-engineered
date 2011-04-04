package com.kirkley.bowling.components.roll;

import com.kirkley.bowling.util.Constants;

/**
 * <pre>
 * A spare is when the bowler knocks down all 10 pins in two rolls of the bowling ball. In
 * this case the pin count for a spare is 10 minus the first throw the bowler threw. * 
 * </pre>
 * 
 * @author Matthew Kirkley
 */
public class Spare implements Throw {

	
	/** The first throw of the frame, which must be an open throw. */
	private Open firstThrow;
	
	/**
	 * Constructs a spare throw. A spare's pin count takes into
	 * account the value of the first throw of the next frame.
	 * @param firstThrow
	 */
	public Spare(final Open firstThrow) {
		this.firstThrow = firstThrow;
	}
	
	@Override
	public int getPinCount() {
		return Constants.TOTAL_PINS_PER_THROW - firstThrow.getPinCount();
	}

}
