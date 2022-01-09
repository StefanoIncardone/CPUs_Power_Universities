package com.CPU.components.ALU.adders.oneBitInputs.half;

import com.CPU.components.ALU.adders.oneBitInputs.OneBitAdder;

public abstract sealed class AbstractHalfAdder extends OneBitAdder permits HalfAdder
{
	protected static final int INPUT_COL_A = 0;
	protected static final int INPUT_COL_B = 1;
	protected static final int OUTPUT_COL_CARRY = 2;
	protected static final int OUTPUT_COL_SUM = 3;

	private static final int NUMBER_OF_INPUTS = 2;
	private static final String[] COLUMN_NAMES = new String[]{ "A", "B", "CARRY OUT", "SUM" };

	public AbstractHalfAdder()
	{
		super( NUMBER_OF_INPUTS, COLUMN_NAMES );
	}

	public final byte[] out( byte A, byte B )
	{
		return this.out( new byte[]{ A, B } );
	}

	public final byte[] out( int A, int B )
	{
		return this.out( (byte) A, (byte) B );
	}
}
