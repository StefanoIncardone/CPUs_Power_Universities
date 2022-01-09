package com.stefano.components.ALU.adders.oneBitInputs;

import com.stefano.components.Component;
import com.stefano.components.ALU.adders.oneBitInputs.full.AbstractFullAdder;
import com.stefano.components.ALU.adders.oneBitInputs.half.AbstractHalfAdder;

public abstract sealed class OneBitAdder extends Component permits AbstractHalfAdder, AbstractFullAdder
{
	public static final int CARRY = 0;
	public static final int SUM = 1;

	private static final int NUMBER_OF_OUTPUTS = 2;

	protected OneBitAdder( int numberOfInputs, String[] columnNames )
	{
		super( numberOfInputs, NUMBER_OF_OUTPUTS, columnNames );
	}
}