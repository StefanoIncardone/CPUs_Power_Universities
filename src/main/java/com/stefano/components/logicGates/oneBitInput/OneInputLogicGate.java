package com.stefano.components.logicGates.oneBitInput;

import com.stefano.components.logicGates.LogicGate;

public abstract class OneInputLogicGate extends LogicGate
{
	protected static final int INPUT_COL = 0;
	protected static final int OUTPUT_COL = 1;

	private static final int NUMBER_OF_INPUTS = 1;

	@Override
	protected int getNumberOfInputs()
	{
		return NUMBER_OF_INPUTS;
	}

	@Override
	protected int getNumberOfOutputs()
	{
		return NUMBER_OF_OUTPUTS;
	}

	@Override
	protected String[] getColumnNames()
	{
		if( COLUMN_NAMES == null )
		{
			COLUMN_NAMES = new String[]{ "A", this.getClass().getSimpleName() + " A" };
		}

		return COLUMN_NAMES;
	}

	public byte out( byte A )
	{
		return this.out( new byte[]{ A } )[ OUTPUT ];
	}

	public byte out( int A )
	{
		return this.out( (byte) A );
	}
}
