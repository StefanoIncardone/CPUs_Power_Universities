package com.stefano.components.ALU.adders.singleBitInput.half;

import com.stefano.components.logicGates.twoBitsInput.AND;
import com.stefano.components.logicGates.twoBitsInput.XOR;

public class HalfAdder extends AbstractHalfAdder
{
	private final XOR xor = new XOR();
	private final AND and = new AND();

	@Override
	protected byte[] out( byte[] input )
	{
		final byte A = input[ INPUT_COL_A ];
		final byte B = input[ INPUT_COL_B ];

		return new byte[]{ and.out( A, B ), xor.out( A, B ) };
	}
}
