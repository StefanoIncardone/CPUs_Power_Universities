package com.stefano.components.logicGates.twoBitsInput;

import com.stefano.components.logicGates.oneBitInput.NOT;

public class IMPLY extends TwoInputLogicGate
{
	private final OR or = new OR();
	private final NOT not = new NOT();

	@Override
	protected byte[] out( byte[] input )
	{
		final byte A = input[ INPUT_COL_A ];
		final byte B = input[ INPUT_COL_B ];

		return new byte[]{ or.out( not.out( A ), B ) };
	}
}