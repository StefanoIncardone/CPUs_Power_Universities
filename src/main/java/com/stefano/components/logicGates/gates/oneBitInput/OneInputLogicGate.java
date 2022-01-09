package com.stefano.components.logicGates.gates.oneBitInput;

import com.stefano.components.logicGates.LogicGate;

public abstract sealed class OneInputLogicGate extends LogicGate permits BUFFER, CONTRADICTION, NOT, TAUTOLOGY
{
	protected static final int INPUT_COL = 0;
	protected static final int OUTPUT_COL = 1;

	private static final int NUMBER_OF_INPUTS = 1;

	protected OneInputLogicGate( String gateName )
	{
		super( NUMBER_OF_INPUTS, new String[]{ "A", gateName + " A" } );
	}

	public final byte out( byte A )
	{
		return this.out( new byte[]{ A } )[ OUTPUT ];
	}

	public final byte out( int A )
	{
		return this.out( (byte) A );
	}
}
