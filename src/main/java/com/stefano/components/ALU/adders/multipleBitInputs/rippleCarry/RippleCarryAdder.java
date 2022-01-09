package com.stefano.components.ALU.adders.multipleBitInputs.rippleCarry;

import com.stefano.components.Component;
import com.stefano.components.ALU.adders.multipleBitInputs.rippleCarry.RCA.twoBits.AbstractTwoBitsRCA;

public abstract sealed class RippleCarryAdder extends Component permits AbstractTwoBitsRCA
{
	public static final int CARRY_OUT = 0;

	protected RippleCarryAdder( int numberOfInputs, int numberOfOutputs, String[] columnNames )
	{
		super( numberOfInputs, numberOfOutputs, columnNames );
	}
}
