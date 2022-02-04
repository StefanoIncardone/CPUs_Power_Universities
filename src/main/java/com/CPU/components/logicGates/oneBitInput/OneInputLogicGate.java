package com.CPU.components.logicGates.oneBitInput;

import com.CPU.components.logicGates.LogicGate;

public abstract sealed class OneInputLogicGate extends LogicGate permits BUFFER, CONTRADICTION, NOT, TAUTOLOGY
{
	public static final int INPUT_COL = 0;

	private static final int NUMBER_OF_INPUTS = 1;

	protected OneInputLogicGate( Class<? extends OneInputLogicGate> gate )
	{
		super( NUMBER_OF_INPUTS, new String[]{ "A", gate.getSimpleName() + " A" } );
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
