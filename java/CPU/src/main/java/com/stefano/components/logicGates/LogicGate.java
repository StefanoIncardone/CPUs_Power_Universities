package com.stefano.components.logicGates;

import com.stefano.components.Component;

public abstract class LogicGate extends Component
{
	protected static final int OUTPUT = 0;

	protected static final int NUMBER_OF_OUTPUTS = 1;

	public LogicGate()
	{
		super();

		super.NUMBER_OF_OUTPUTS = NUMBER_OF_OUTPUTS;
	}
}
