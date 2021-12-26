package com.stefano.components.ALU.adders.multipleBitsInput.rippleCarry.twoBits;

import com.stefano.components.ALU.adders.singleBitInput.Adder;
import com.stefano.components.ALU.adders.singleBitInput.full.FullAdder;

public class TwoBitsRCA extends AbstractTwoBitsRCA
{
	final FullAdder firstFullAdder = new FullAdder();
	final FullAdder secondFullAdder = new FullAdder();

	@Override
	protected byte[] out( byte[] input )
	{
		final byte A1 = input[ INPUT_COL_A1 ];
		final byte A0 = input[ INPUT_COL_A0 ];
		final byte B1 = input[ INPUT_COL_B1 ];
		final byte B0 = input[ INPUT_COL_B0 ];

		byte[] firstFullAdderOutput = firstFullAdder.out( 0, A0, B0 );
		byte[] secondFullAdderOutput = secondFullAdder.out( firstFullAdderOutput[ Adder.CARRY ], A1, B1 );

		return new byte[]
		{
			secondFullAdderOutput[ Adder.CARRY ],
			secondFullAdderOutput[ Adder.SUM ],
			firstFullAdderOutput[ Adder.SUM ]
		};
	}
}
