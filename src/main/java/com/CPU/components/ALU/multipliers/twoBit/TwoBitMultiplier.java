package com.CPU.components.ALU.multipliers.twoBit;

import com.CPU.components.ALU.adders.oneBitInputs.half.HalfAdder;
import com.CPU.components.logicGates.twoBitsInput.AND;

public final class TwoBitMultiplier extends AbstractTwoBitMultiplier
{
	private final AND and_0 = new AND();
	private final AND and_1 = new AND();
	private final AND and_2 = new AND();
	private final AND and_3 = new AND();
	private final HalfAdder halfAdder_0 = new HalfAdder();
	private final HalfAdder halfAdder_1 = new HalfAdder();

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
