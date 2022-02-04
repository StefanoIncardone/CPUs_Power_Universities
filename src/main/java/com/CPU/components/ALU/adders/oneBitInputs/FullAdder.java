package com.CPU.components.ALU.adders.oneBitInputs;

import com.CPU.components.logicGates.twoBitsInput.OR;

public final class FullAdder extends OneBitAdder
{
	public static final int IMPUT_COL_CARRY = 0;
	public static final int INPUT_COL_A = 1;
	public static final int INPUT_COL_B = 2;

	private static final int NUMBER_OF_INPUTS = 3;
	private static final String[] COLUMN_NAMES = new String[]{ "CARRY IN", "A", "B", "CARRY OUT", "SUM" };

	private final HalfAdder halfAdder_0 = new HalfAdder();
	private final HalfAdder halfAdder_1 = new HalfAdder();
	private final OR or = new OR();

	public FullAdder()
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

	@Override
	public byte[] out( byte... inputs )
	{
		validateInput( inputs );

		byte C = inputs[ IMPUT_COL_CARRY ];
		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		byte[] firstHalfAdderOutput = halfAdder_0.out( A, B );
		byte[] secondHalfAdderOutput = halfAdder_1.out( firstHalfAdderOutput[ SUM ], C );
		byte carryOutput = or.out( firstHalfAdderOutput[ CARRY_OUT ], secondHalfAdderOutput[ CARRY_OUT ] );
	
		return new byte[]{ carryOutput, secondHalfAdderOutput[ SUM ] };
	}
}
