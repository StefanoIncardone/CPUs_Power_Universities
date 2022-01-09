package com.stefano.components.logicGates;

import com.stefano.components.Component;
import com.stefano.components.logicGates.gates.oneBitInput.OneInputLogicGate;
import com.stefano.components.logicGates.gates.twoBitsInput.TwoInputLogicGate;

public abstract sealed class LogicGate extends Component permits OneInputLogicGate, TwoInputLogicGate
{
	protected static final int OUTPUT = 0;

	private static final int NUMBER_OF_OUTPUTS = 1;

	protected LogicGate( int numberOfInputs, String[] columnNames )
	{
		super( numberOfInputs, NUMBER_OF_OUTPUTS, columnNames );
	}
}
