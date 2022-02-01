package com.CPU.components.ALU.adders.multipleBitInputs.fourBit;

import com.CPU.components.ALU.adders.multipleBitInputs.twoBit.TwoBitsRCA;

public final class FourBitsRCA extends AbstractFourBitsRCA
{
	private final TwoBitsRCA twoBitsRCA_0 = new TwoBitsRCA();
	private final TwoBitsRCA twoBitsRCA_1 = new TwoBitsRCA();

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
