package com.kirkley.bowling.components.roll;


/**
 * <pre>
 * Represents a Strike throw.  A strike consists of knocking down all 10 pins on 
 * the bowler's first throw. 
 * </pre>
 * @author Matthew Kirkley
 */
public class Strike implements Throw{

    private int pinCount = 10;
    
	@Override
	public int getPinCount() {
		//A strike means all 10 pins were knocked down.
		return pinCount;
	}
	

}
