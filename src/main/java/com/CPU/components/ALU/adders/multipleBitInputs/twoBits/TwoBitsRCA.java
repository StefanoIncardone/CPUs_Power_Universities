package com.CPU.components.ALU.adders.multipleBitInputs.twoBits;

import com.CPU.components.ALU.adders.oneBitInputs.OneBitAdder;
import com.CPU.components.ALU.adders.oneBitInputs.full.FullAdder;

public final class TwoBitsRCA extends AbstractTwoBitsRCA
{
	private final FullAdder firstFullAdder = new FullAdder();
	private final FullAdder secondFullAdder = new FullAdder();

	@Override
	protected byte[] out( byte[] input )
	{
		byte A1 = input[ INPUT_COL_A1 ];
		byte A0 = input[ INPUT_COL_A0 ];
		byte B1 = input[ INPUT_COL_B1 ];
		byte B0 = input[ INPUT_COL_B0 ];

		byte[] firstFullAdderOutput = firstFullAdder.out( 0, A0, B0 );
		byte[] secondFullAdderOutput = secondFullAdder.out( firstFullAdderOutput[ OneBitAdder.CARRY ], A1, B1 );

		return new byte[]
		{
			secondFullAdderOutput[ OneBitAdder.CARRY ],
			secondFullAdderOutput[ OneBitAdder.SUM ],
			firstFullAdderOutput[ OneBitAdder.SUM ]
		};
	}
}
