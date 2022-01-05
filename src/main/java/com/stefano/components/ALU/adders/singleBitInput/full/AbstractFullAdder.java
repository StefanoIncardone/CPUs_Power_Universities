package com.stefano.components.ALU.adders.singleBitInput.full;

import com.stefano.components.ALU.adders.singleBitInput.Adder;

public abstract class AbstractFullAdder extends Adder
{
	protected static final int IMPUT_COL_CARRY = 0;
	protected static final int INPUT_COL_A = 1;
	protected static final int INPUT_COL_B = 2;
	protected static final int OUTPUT_COL_CARRY = 3;
	protected static final int OUTPUT_COL_SUM = 4;

	private static final int NUMBER_OF_INPUTS = 3;
	private static final String[] COLUMN_NAMES = new String[]{ "CARRY IN", "A", "B", "CARRY OUT", "SUM" };

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

	public byte[] out( byte C, byte A, byte B )
	{
		return this.out( new byte[]{ C, A, B } );
	}

	public byte[] out( int C, int A, int B )
	{
		return this.out( (byte) C, (byte) A, (byte) B );
	}
}
