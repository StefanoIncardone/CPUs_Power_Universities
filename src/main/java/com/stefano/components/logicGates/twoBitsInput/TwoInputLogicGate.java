package com.stefano.components.logicGates.twoBitsInput;

import com.stefano.components.logicGates.LogicGate;

public abstract class TwoInputLogicGate extends LogicGate
{
	protected static final int INPUT_COL_A = 0;
	protected static final int INPUT_COL_B = 1;
	protected static final int OUTPUT_COL = 2;

	private static final int NUMBER_OF_INPUTS = 2;

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
			COLUMN_NAMES = new String[]{ "A", "B", "A " + this.getClass().getSimpleName() + " B" };
		}

		return COLUMN_NAMES;
	}

	public byte out( byte A, byte B )
	{
		return this.out( new byte[]{ A, B } )[ OUTPUT ];
	}

	public byte out( int A, int B )
	{
		return this.out( (byte) A, (byte) B );
	}
}
