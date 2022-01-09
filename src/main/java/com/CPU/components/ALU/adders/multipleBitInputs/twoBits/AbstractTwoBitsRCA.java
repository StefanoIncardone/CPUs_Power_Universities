package com.CPU.components.ALU.adders.multipleBitInputs.twoBits;

import com.CPU.components.ALU.adders.multipleBitInputs.RippleCarryAdder;

public abstract sealed class AbstractTwoBitsRCA extends RippleCarryAdder permits TwoBitsRCA
{
	protected static final int INPUT_COL_A1 = 0;
	protected static final int INPUT_COL_A0 = 1;
	protected static final int INPUT_COL_B1 = 2;
	protected static final int INPUT_COL_B0 = 3;
	protected static final int OUTPUT_COL_CARRY = 4;
	protected static final int OUTPUT_COL_S1 = 5;
	protected static final int OUTPUT_COL_S0 = 6;

	protected static final int S1 = 1;
	protected static final int S0 = 2;

	private static final int NUMBER_OF_INPUTS = 4;
	private static final int NUMBER_OF_OUTPUTS = 3;
	private static final String[] COLUMN_NAMES = new String[]{ "A1", "A0", "B1", "B0", "CARRY OUT", "S1", "S0" };

	public AbstractTwoBitsRCA()
	{
		super( NUMBER_OF_INPUTS, NUMBER_OF_OUTPUTS, COLUMN_NAMES );
	}

	public final byte[] out( byte A1, byte A0, byte B1, byte B0 )
	{
		return this.out( new byte[]{ A1, A0, B1, B0 } );
	}

	public final byte[] out( int A1, int A0, int B1, int B0 )
	{
		return this.out( (byte) A1, (byte) A0, (byte) B1, (byte) B0 );
	}
}