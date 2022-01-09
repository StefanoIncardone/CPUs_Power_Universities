package com.CPU.components.ALU.adders.multipleBitInputs;

import com.CPU.components.Component;
import com.CPU.components.ALU.adders.multipleBitInputs.twoBits.AbstractTwoBitsRCA;

public abstract sealed class RippleCarryAdder extends Component permits AbstractTwoBitsRCA
{
	public static final int CARRY_OUT = 0;

	protected RippleCarryAdder( int numberOfInputs, int numberOfOutputs, String[] columnNames )
	{
		super( numberOfInputs, numberOfOutputs, columnNames );
	}
}
