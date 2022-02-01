package com.CPU.components.ALU.adders.multipleBitInputs.twoBit;

import com.CPU.components.ALU.adders.multipleBitInputs.RippleCarryAdder;

public abstract sealed class AbstractTwoBitsRCA extends RippleCarryAdder permits TwoBitsRCA
{
	public static final int INPUT_COL_CARRY_IN = 0;
	public static final int INPUT_COL_A1 = 1;
	public static final int INPUT_COL_A0 = 2;
	public static final int INPUT_COL_B1 = 3;
	public static final int INPUT_COL_B0 = 4;

	public static final int S1 = 1;
	public static final int S0 = 2;

	private static final int NUMBER_OF_INPUTS = 5;
	private static final int NUMBER_OF_OUTPUTS = 3;
	private static final String[] COLUMN_NAMES = new String[]
	{
		"CARRY_IN",
		"A1",
		"A0",
		"B1",
		"B0",
		"CARRY OUT",
		"S1",
		"S0"
	};

	public AbstractTwoBitsRCA()
	{
		super( NUMBER_OF_INPUTS, NUMBER_OF_OUTPUTS, COLUMN_NAMES );
	}

	public final byte[] out( byte CARRY_IN, byte A1, byte A0, byte B1, byte B0 )
	{
		return this.out( new byte[]{ CARRY_IN, A1, A0, B1, B0 } );
	}

	public final byte[] out( int CARRY_IN, int A1, int A0, int B1, int B0 )
	{
		return this.out( (byte) CARRY_IN, (byte) A1, (byte) A0, (byte) B1, (byte) B0 );
	}
}
