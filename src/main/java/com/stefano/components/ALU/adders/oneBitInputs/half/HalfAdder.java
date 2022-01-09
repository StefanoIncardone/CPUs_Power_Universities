package com.stefano.components.ALU.adders.oneBitInputs.half;

import com.stefano.components.logicGates.gates.twoBitsInput.AND;
import com.stefano.components.logicGates.gates.twoBitsInput.XOR;

public final class HalfAdder extends AbstractHalfAdder
{
	private final XOR xor = new XOR();
	private final AND and = new AND();

	@Override
	protected byte[] out( byte[] input )
	{
		byte A = input[ INPUT_COL_A ];
		byte B = input[ INPUT_COL_B ];

		return new byte[]{ and.out( A, B ), xor.out( A, B ) };
	}
}
