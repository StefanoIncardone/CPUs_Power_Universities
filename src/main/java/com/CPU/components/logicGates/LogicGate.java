package com.CPU.components.logicGates;

import com.CPU.components.Component;
import com.CPU.components.logicGates.oneBitInput.OneInputLogicGate;
import com.CPU.components.logicGates.twoBitsInput.TwoInputLogicGate;

public abstract sealed class LogicGate extends Component permits OneInputLogicGate, TwoInputLogicGate
{
	protected static final int OUTPUT = 0;

	private static final int NUMBER_OF_OUTPUTS = 1;

	protected LogicGate( int numberOfInputs, String[] columnNames )
	{
		super( numberOfInputs, NUMBER_OF_OUTPUTS, columnNames );
	}
}
