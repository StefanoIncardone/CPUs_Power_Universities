package com.CPU.components.ALU.adders.multipleBitInputs;

public final class FourBitsRCA extends RippleCarryAdder
{
	public static final int INPUT_COL_CARRY_IN = 0;
	public static final int INPUT_COL_A3 = 1;
	public static final int INPUT_COL_A2 = 2;
	public static final int INPUT_COL_A1 = 3;
	public static final int INPUT_COL_A0 = 4;
	public static final int INPUT_COL_B3 = 5;
	public static final int INPUT_COL_B2 = 6;
	public static final int INPUT_COL_B1 = 7;
	public static final int INPUT_COL_B0 = 8;

	public static final int S3 = 1;
	public static final int S2 = 2;
	public static final int S1 = 3;
	public static final int S0 = 4;

	private static final int NUMBER_OF_INPUTS = 9;
	private static final int NUMBER_OF_OUTPUTS = 5;
	private static final String[] COLUMN_NAMES = new String[]
	{
		"CARRY_IN",
		"A3",
		"A2",
		"A1",
		"A0",
		"B3",
		"B2",
		"B1",
		"B0",
		"CARRY OUT",
		"S3",
		"S2",
		"S1",
		"S0"
	};

	private final TwoBitsRCA twoBitsRCA_0 = new TwoBitsRCA();
	private final TwoBitsRCA twoBitsRCA_1 = new TwoBitsRCA();

	public FourBitsRCA()
	{
		super( NUMBER_OF_INPUTS, NUMBER_OF_OUTPUTS, COLUMN_NAMES );
	}

	public final byte[] out( byte CARRY_IN, byte A3, byte A2, byte A1, byte A0, byte B3, byte B2, byte B1, byte B0 )
	{
		return this.out( new byte[]{ CARRY_IN, A3, A2, A1, A0, B3, B2, B1, B0 } );
	}

	public final byte[] out( int CARRY_IN, int A3, int A2, int A1, int A0, int B3, int B2, int B1, int B0 )
	{
		return this.out
		(
			(byte) CARRY_IN, (byte) A3, (byte) A2, (byte) A1, (byte) A0, (byte) B3, (byte) B2, (byte) B1, (byte) B0
		);
	}

	@Override
	protected byte[] out( byte... inputs )
	{
		validateInput( inputs );

		byte C = inputs[ INPUT_COL_CARRY_IN ];
		byte A3 = inputs[ INPUT_COL_A3 ];
		byte A2 = inputs[ INPUT_COL_A2 ];
		byte A1 = inputs[ INPUT_COL_A1 ];
		byte A0 = inputs[ INPUT_COL_A0 ];
		byte B3 = inputs[ INPUT_COL_B3 ];
		byte B2 = inputs[ INPUT_COL_B2 ];
		byte B1 = inputs[ INPUT_COL_B1 ];
		byte B0 = inputs[ INPUT_COL_B0 ];

		byte[] twoBitsRCA_0_Out = twoBitsRCA_0.out( C, A1, A0, B1, B0 );
		byte[] twoBitsRCA_1_Out = twoBitsRCA_1.out( twoBitsRCA_0_Out[ CARRY_OUT ], A3, A2, B3, B2 );

		return new byte[]
		{
			twoBitsRCA_1_Out[ CARRY_OUT ],
			twoBitsRCA_1_Out[ TwoBitsRCA.S1 ],
			twoBitsRCA_1_Out[ TwoBitsRCA.S0 ],
			twoBitsRCA_0_Out[ TwoBitsRCA.S1 ],
			twoBitsRCA_0_Out[ TwoBitsRCA.S0 ]
		};
	}
}
