package com.CPU.components.ALU.comparators.oneBit;

import com.CPU.components.ALU.comparators.Comparator;

public abstract sealed class AbstractOneBitComparator extends Comparator permits OneBitComparator
{
	protected static final int INPUT_COL_A = 0;
	protected static final int INPUT_COL_B = 1;
	protected static final int OUTPUT_COL_LESS = 2;
	protected static final int OUTPUT_COL_LESS_OR_EQUAL = 3;
	protected static final int OUTPUT_COL_EQUAL = 4;
	protected static final int OUTPUT_COL_GREATER_OR_EQUAL = 5;
	protected static final int OUTPUT_COL_GREATER = 6;

	private static final int NUMBER_OF_INPUTS = 2;
	private static final String[] COLUMN_NAMES = new String[]
	{
		"A",
		"B",
		"LESS",
		"LESS OR EQUAL",
		"EQUAL",
		"GREATER OR EQUAL",
		"GREATER"
	};

	public AbstractOneBitComparator()
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
