package com.stefano.components.logicGates.twoBitsInput;

import com.stefano.components.logicGates.oneBitInput.NOT;

public class NIMPLY extends TwoInputLogicGate
{
	private final IMPLY imply = new IMPLY();
	private final NOT not = new NOT();

	@Override
	protected byte[] out( byte[] input )
	{
		final byte A = input[ INPUT_COL_A ];
		final byte B = input[ INPUT_COL_B ];

		return new byte[]{ not.out( imply.out( A, B ) ) };
	}
}