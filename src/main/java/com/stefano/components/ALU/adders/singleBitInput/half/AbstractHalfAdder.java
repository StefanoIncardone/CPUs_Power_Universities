package com.stefano.components.ALU.adders.singleBitInput.half;

import com.stefano.components.ALU.adders.singleBitInput.Adder;

public abstract class AbstractHalfAdder extends Adder
{
	protected static final int INPUT_COL_A = 0;
	protected static final int INPUT_COL_B = 1;
	protected static final int OUTPUT_COL_CARRY = 2;
	protected static final int OUTPUT_COL_SUM = 3;

	private static final int NUMBER_OF_INPUTS = 2;
	private static final String[] COLUMN_NAMES = new String[]{ "A", "B", "CARRY OUT", "SUM" };

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
		return COLUMN_NAMES;
	}

	public byte[] out( byte A, byte B )
	{
		return this.out( new byte[]{ A, B } );
	}

	public byte[] out( int A, int B )
	{
		return this.out( (byte) A, (byte) B );
	}
}
