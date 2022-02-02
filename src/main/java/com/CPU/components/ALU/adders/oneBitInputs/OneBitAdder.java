package com.CPU.components.ALU.adders.oneBitInputs;

import com.CPU.components.ALU.adders.Adder;

public abstract sealed class OneBitAdder extends Adder permits HalfAdder, FullAdder
{
	public static final int SUM = 1;

	private static final int NUMBER_OF_OUTPUTS = 2;

	protected OneBitAdder( int numberOfInputs, String[] columnNames )
	{
		super( numberOfInputs, NUMBER_OF_OUTPUTS, columnNames );
	}
}