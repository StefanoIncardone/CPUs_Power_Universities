package com.CPU.components.ALU.multipliers.twoBit;

import com.CPU.components.ALU.multipliers.Multiplier;

public abstract sealed class AbstractTwoBitMultiplier extends Multiplier permits TwoBitMultiplier
{
	public static final int INPUT_COL_A1 = 0;
	public static final int INPUT_COL_A0 = 1;
	public static final int INPUT_COL_B1 = 2;
	public static final int INPUT_COL_B0 = 3;
	public static final int OUTPUT_COL_P3 = 4;
	public static final int OUTPUT_COL_P2 = 5;
	public static final int OUTPUT_COL_P1 = 6;
	public static final int OUTPUT_COL_P0 = 7;

	public static final int P3 = 0;
	public static final int P2 = 1;
	public static final int P1 = 2;
	public static final int P0 = 3;

	private static final int NUMBER_OF_INPUTS = 4;
	private static final int NUMBER_OF_OUTPUTS = 4;
	private static final String[] COLUMN_NAMES = new String[]{ "A1", "A0", "B1", "B0", "P3", "P2", "P1", "P0" };

	public AbstractTwoBitMultiplier()
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
