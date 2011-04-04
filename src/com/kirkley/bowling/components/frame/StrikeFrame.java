package com.kirkley.bowling.components.frame;

import com.kirkley.bowling.components.roll.Throw;
import com.kirkley.bowling.util.Constants;


public class StrikeFrame implements Frame{

	/** The next ball that was thrown. */
	private Throw nextBall;
	
	/** The 'next next' ball that was thrown. */
	private Throw nextNextBall;
	
	public StrikeFrame(final Throw nextBall, final Throw nextNextBall) {
		this.nextBall = nextBall;
		this.nextNextBall = nextNextBall;
	}
	
	@Override
	public int getScore() {
		return Constants.TOTAL_PINS_PER_THROW + this.nextBall.getPinCount() + this.nextNextBall.getPinCount();
	}
	
	@Override
	public String toString() {
	    return "Strike: ["+ getScore() + "]";
	}

}
