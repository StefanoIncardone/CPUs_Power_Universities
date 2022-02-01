package com.CPU.components.ALU.adders.oneBitInputs.half;

import com.CPU.components.logicGates.twoBitsInput.AND;
import com.CPU.components.logicGates.twoBitsInput.XOR;

public final class HalfAdder extends AbstractHalfAdder
{
	private final XOR xor = new XOR();
	private final AND and = new AND();

	@Override
	public byte[] out( byte... inputs )
	{
		validateInput( inputs );

		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ and.out( A, B ), xor.out( A, B ) };
	}
}
