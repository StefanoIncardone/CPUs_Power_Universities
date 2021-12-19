package com.stefano.components.math.adders;

import com.stefano.components.Component;

public interface Adder extends Component
{
	public static final int SUM = 0;
	public static final int CARRY = 1;

	public static final int NUMBER_OF_OUTPUTS = 2;
}