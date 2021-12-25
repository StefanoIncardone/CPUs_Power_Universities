package com.stefano.components.ALU.rippleCarryAdders.Bit_2;

import com.stefano.components.ALU.adders.Adder;
import com.stefano.components.ALU.adders.full.FullAdder;
import com.stefano.components.ALU.adders.half.HalfAdder;

public class RCA_2 extends AbstractRCA_2
{
	final HalfAdder halfAdder = new HalfAdder();
	final FullAdder fullAdder = new FullAdder();

	@Override
	protected byte[] out( byte[] input )
	{
		final byte A0 = input[ INPUT_COL_A0 ];
		final byte A1 = input[ INPUT_COL_A1 ];
		final byte B0 = input[ INPUT_COL_B0 ];
		final byte B1 = input[ INPUT_COL_B1 ];

		byte[] halfAdderOutput = halfAdder.out( A0, B0 );
		byte[] fullAdderOutput = fullAdder.out( halfAdderOutput[ Adder.CARRY ], A1, B1 );

		return new byte[]
		{
			fullAdderOutput[ Adder.CARRY ],
			fullAdderOutput[ Adder.SUM ],
			halfAdderOutput[ Adder.SUM ]
		};
	}
}
