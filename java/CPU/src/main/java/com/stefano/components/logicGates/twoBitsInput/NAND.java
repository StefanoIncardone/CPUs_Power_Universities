package com.stefano.components.logicGates.twoBitsInput;

import com.stefano.components.logicGates.oneBitInput.NOT;

public class NAND extends TwoInputLogicGate
{
	private final NOT not = new NOT();
	private final AND and = new AND();

	@Override
	protected byte[] out( byte[] input )
	{
		final byte A = input[ INPUT_COL_A ];
		final byte B = input[ INPUT_COL_B ];

		return new byte[]{ not.out( and.out( A, B ) ) };
	}
}