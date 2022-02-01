package com.CPU.components.ALU.adders.multipleBitInputs;

import com.CPU.components.ALU.adders.Adder;
import com.CPU.components.ALU.adders.multipleBitInputs.fourBit.AbstractFourBitsRCA;
import com.CPU.components.ALU.adders.multipleBitInputs.twoBit.AbstractTwoBitsRCA;

public abstract sealed class RippleCarryAdder extends Adder permits AbstractTwoBitsRCA, AbstractFourBitsRCA
{
	protected RippleCarryAdder( int numberOfInputs, int numberOfOutputs, String[] columnNames )
	{
		super( numberOfInputs, numberOfOutputs, columnNames );
	}
}
