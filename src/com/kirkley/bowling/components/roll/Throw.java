package com.kirkley.bowling.components.roll;

public interface Throw {

	/**
	 * @return raw pin count of this throw, this value does not take into account 
	 * 		   any bonus scoring that results from a Strike or Spare roll. For example
	 * 		   for a Strike, this should return 10, for a spare it should return (10-firstRoll).
	 */
	int getPinCount();
		
}
