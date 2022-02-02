package com.CPU.components.ALU.adders.multipleBitInputs;

import com.CPU.components.ALU.adders.Adder;

public abstract sealed class RippleCarryAdder extends Adder permits TwoBitsRCA, FourBitsRCA
{
	protected RippleCarryAdder( int numberOfInputs, int numberOfOutputs, String[] columnNames )
	{
		super( numberOfInputs, numberOfOutputs, columnNames );
	}
}
