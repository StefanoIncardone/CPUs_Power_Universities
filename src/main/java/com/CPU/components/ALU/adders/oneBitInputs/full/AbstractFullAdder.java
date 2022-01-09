package com.CPU.components.ALU.adders.oneBitInputs.full;

import com.CPU.components.ALU.adders.oneBitInputs.OneBitAdder;

public abstract sealed class AbstractFullAdder extends OneBitAdder permits FullAdder
{
	protected static final int IMPUT_COL_CARRY = 0;
	protected static final int INPUT_COL_A = 1;
	protected static final int INPUT_COL_B = 2;
	protected static final int OUTPUT_COL_CARRY = 3;
	protected static final int OUTPUT_COL_SUM = 4;

	private static final int NUMBER_OF_INPUTS = 3;
	private static final String[] COLUMN_NAMES = new String[]{ "CARRY IN", "A", "B", "CARRY OUT", "SUM" };

	public AbstractFullAdder()
	{
		super( NUMBER_OF_INPUTS, COLUMN_NAMES );
	}

	public final byte[] out( byte C, byte A, byte B )
	{
		return this.out( new byte[]{ C, A, B } );
	}

	public final byte[] out( int C, int A, int B )
	{
		return this.out( (byte) C, (byte) A, (byte) B );
	}
}
