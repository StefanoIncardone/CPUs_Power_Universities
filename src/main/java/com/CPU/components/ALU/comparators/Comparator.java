package com.CPU.components.ALU.comparators;

import com.CPU.components.Component;

public abstract sealed class Comparator extends Component permits OneBitComparator
{
	public static final int LESS = 0;
	public static final int LESS_OR_EQUAL = 1;
	public static final int EQUAL = 2;
	public static final int GREATER_OR_EQUAL = 3;
	public static final int GREATER = 4;

	private static final int NUMBER_OF_OUTPUTS = 5;

	protected Comparator( int numberOfInputs, String[] columnNames )
	{
		super( numberOfInputs, NUMBER_OF_OUTPUTS, columnNames );
	}
}
