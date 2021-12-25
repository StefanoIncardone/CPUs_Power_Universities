package com.stefano.components.ALU.adders.half;

import com.stefano.components.logicGates.doubleInput.AND;
import com.stefano.components.logicGates.doubleInput.XOR;

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
