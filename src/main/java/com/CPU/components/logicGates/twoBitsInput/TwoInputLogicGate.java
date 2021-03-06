package com.CPU.components.logicGates.twoBitsInput;

import com.CPU.components.logicGates.LogicGate;

public abstract sealed class TwoInputLogicGate extends LogicGate
	permits AND, CIMPLY, CNIMPLY, IMPLY, NAND, NIMPLY, NOR, OR, XNOR, XOR
{
	public static final int INPUT_COL_A = 0;
	public static final int INPUT_COL_B = 1;
	public static final int OUTPUT_COL = 2;

	private static final int NUMBER_OF_INPUTS = 2;

	protected TwoInputLogicGate( Class<? extends TwoInputLogicGate> gate )
	{
		super( NUMBER_OF_INPUTS, new String[]{ "A", "B", "A " + gate.getSimpleName() + " B" } );
	}

	public final byte out( byte A, byte B )
	{
		return this.out( new byte[]{ A, B } )[ OUTPUT ];
	}

	public final byte out( int A, int B )
	{
		return this.out( (byte) A, (byte) B );
	}
}
