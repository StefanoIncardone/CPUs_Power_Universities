package com.CPU.components.ALU.adders.multipleBitInputs.twoBit;

import com.CPU.components.ALU.adders.oneBitInputs.full.FullAdder;

public final class TwoBitsRCA extends AbstractTwoBitsRCA
{
	private final FullAdder fullAdder_0 = new FullAdder();
	private final FullAdder fullAdder_1 = new FullAdder();

	@Override
	protected byte[] out( byte... inputs )
	{
		validateInput( inputs );

		byte C = inputs[ INPUT_COL_CARRY_IN ];
		byte A1 = inputs[ INPUT_COL_A1 ];
		byte A0 = inputs[ INPUT_COL_A0 ];
		byte B1 = inputs[ INPUT_COL_B1 ];
		byte B0 = inputs[ INPUT_COL_B0 ];

		byte[] fullAdder_0_Out = fullAdder_0.out( C, A0, B0 );
		byte[] fullAdder_1_Out = fullAdder_1.out( fullAdder_0_Out[ CARRY_OUT ], A1, B1 );

		return new byte[]
		{
			fullAdder_1_Out[ CARRY_OUT ],
			fullAdder_1_Out[ FullAdder.SUM ],
			fullAdder_0_Out[ FullAdder.SUM ]
		};
	}
}
