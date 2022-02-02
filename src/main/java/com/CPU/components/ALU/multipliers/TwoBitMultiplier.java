package com.CPU.components.ALU.multipliers;

import com.CPU.components.ALU.adders.oneBitInputs.HalfAdder;
import com.CPU.components.logicGates.twoBitsInput.AND;

public final class TwoBitMultiplier extends Multiplier
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

	private final AND and_0 = new AND();
	private final AND and_1 = new AND();
	private final AND and_2 = new AND();
	private final AND and_3 = new AND();
	private final HalfAdder halfAdder_0 = new HalfAdder();
	private final HalfAdder halfAdder_1 = new HalfAdder();

	public TwoBitMultiplier()
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

	@Override
	protected byte[] out( byte... inputs )
	{
		validateInput( inputs );

		byte A1 = inputs[ INPUT_COL_A1 ];
		byte A0 = inputs[ INPUT_COL_A0 ];
		byte B1 = inputs[ INPUT_COL_B1 ];
		byte B0 = inputs[ INPUT_COL_B0 ];

		byte And_0_Out = and_0.out( A0, B0 );
		byte And_1_Out = and_1.out( A0, B1 );
		byte And_2_Out = and_2.out( A1, B0 );
		byte And_3_Out = and_3.out( A1, B1 );

		byte[] halfAdder_0_Out = halfAdder_0.out( And_1_Out, And_2_Out );
		byte[] halfAdder_1_Out = halfAdder_1.out( halfAdder_0_Out[ HalfAdder.CARRY_OUT ], And_3_Out );

		return new byte[]
		{
			halfAdder_1_Out[ HalfAdder.CARRY_OUT ],
			halfAdder_1_Out[ HalfAdder.SUM ],
			halfAdder_0_Out[ HalfAdder.SUM ],
			And_0_Out
		};
	}
}
