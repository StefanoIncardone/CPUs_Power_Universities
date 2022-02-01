package com.CPU.components.ALU.multipliers;

import com.CPU.components.Component;
import com.CPU.components.ALU.multipliers.twoBit.AbstractTwoBitMultiplier;

public abstract sealed class Multiplier extends Component permits AbstractTwoBitMultiplier
{
	protected Multiplier( int numberOfInputs, int numberOfOutputs, String[] columnNames )
	{
		super( numberOfInputs, numberOfOutputs, columnNames );
	}
}