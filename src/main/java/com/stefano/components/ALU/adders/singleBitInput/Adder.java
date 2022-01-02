package com.stefano.components.ALU.adders.singleBitInput;

import com.stefano.components.Component;

public abstract class Adder extends Component
{
	public static final int CARRY = 0;
	public static final int SUM = 1;

	protected static final int NUMBER_OF_OUTPUTS = 2;
}