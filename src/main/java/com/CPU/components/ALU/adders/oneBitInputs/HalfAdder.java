package com.CPU.components.ALU.adders.oneBitInputs;

import com.CPU.components.logicGates.twoBitsInput.AND;
import com.CPU.components.logicGates.twoBitsInput.XOR;

public final class HalfAdder extends OneBitAdder
{
	public static final int INPUT_COL_A = 0;
	public static final int INPUT_COL_B = 1;

	private static final int NUMBER_OF_INPUTS = 2;
	private static final String[] COLUMN_NAMES = new String[]{ "A", "B", "CARRY OUT", "SUM" };

	private final XOR xor = new XOR();
	private final AND and = new AND();

	public HalfAdder()
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

	@Override
	public byte[] out( byte... inputs )
	{
		validateInput( inputs );

		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ and.out( A, B ), xor.out( A, B ) };
	}
}
