package com.kirkley.bowling.components.frame;

/**
 * A frame of 10-pin bowling. The number of balls thrown on a frame depends on the following.
 * <ul>
 * 	<li>If a strike is bowled, the frame consists of 1 throw</li>
 *  <li>If the frame is the 10th frame (or the last frame of play), up to three balls can be thrown</li>
 *  <li>Any other situation, a frame will consist of two throws</li>
 * </ul>
 * 
 * @author Matthew Kirkley
 */
public interface Frame {
	
	/**	
	 * @return the total score contribution of this frame.  For example a Strike frame will consist of 
	 * 	       10 points for the 10 pins knocked down, plus the value of the next two Throws.
	 */
	int getScore();
	
}
