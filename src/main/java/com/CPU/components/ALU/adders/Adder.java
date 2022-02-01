package com.CPU.components.ALU.adders;

import com.CPU.components.Component;
import com.CPU.components.ALU.adders.multipleBitInputs.RippleCarryAdder;
import com.CPU.components.ALU.adders.oneBitInputs.OneBitAdder;

public abstract sealed class Adder extends Component permits OneBitAdder, RippleCarryAdder
{
	public static final int CARRY_OUT = 0;
	
	protected Adder( int numberOfInputs, int numberOfOutputs, String[] columnNames )
	{
		super( numberOfInputs, numberOfOutputs, columnNames );
	}
}
