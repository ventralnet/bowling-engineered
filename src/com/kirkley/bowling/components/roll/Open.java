package com.kirkley.bowling.components.roll;


/**
 * <pre>
 * An open frame is when the bowling bowls neither a strike or space.
 * </pre>
 * 
 * @author Matthew Kirkley
 */
public class Open implements Throw {

	/** Total number of pins bowling knocked down. */
	private int pinCount;

	/**
	 * Constructs an open throw. The pin count is required.
	 * 
	 * @param pinCount
	 */
	public Open(final int pinCount) {
		this.pinCount = pinCount;
	}

	@Override
	public int getPinCount() {
		return pinCount;
	}

}
