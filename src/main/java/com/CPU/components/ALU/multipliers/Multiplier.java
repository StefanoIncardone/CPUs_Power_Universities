package com.CPU.components.ALU.multipliers;

import com.CPU.components.Component;

public abstract sealed class Multiplier extends Component permits TwoBitMultiplier
{
	protected Multiplier( int numberOfInputs, int numberOfOutputs, String[] columnNames )
	{
		super( numberOfInputs, numberOfOutputs, columnNames );
	}
}