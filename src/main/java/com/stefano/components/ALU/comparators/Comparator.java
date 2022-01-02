package com.stefano.components.ALU.comparators;

import com.stefano.components.Component;

public abstract class Comparator extends Component
{
	public static final int LESS = 0;
	public static final int LESS_OR_EQUAL = 1;
	public static final int EQUAL = 2;
	public static final int GREATER_OR_EQUAL = 3;
	public static final int GREATER = 4;

	protected static final int NUMBER_OF_OUTPUTS = 5;
}
