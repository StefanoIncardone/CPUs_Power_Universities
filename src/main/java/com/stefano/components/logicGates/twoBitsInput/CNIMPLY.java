package com.stefano.components.logicGates.twoBitsInput;

import com.stefano.components.logicGates.oneBitInput.NOT;

public class CNIMPLY extends TwoInputLogicGate
{
	private final CIMPLY cimply = new CIMPLY();
	private final NOT not = new NOT();

	@Override
	protected byte[] out( byte[] input )
	{
		final byte A = input[ INPUT_COL_A ];
		final byte B = input[ INPUT_COL_B ];

		return new byte[]{ not.out( cimply.out( A, B ) ) };
	}
}