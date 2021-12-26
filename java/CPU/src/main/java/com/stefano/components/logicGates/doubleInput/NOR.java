package com.stefano.components.logicGates.doubleInput;

import com.stefano.components.logicGates.singleInput.NOT;

public class NOR extends TwoInputLogicGate
{
	private final NOT not = new NOT();
	private final OR or = new OR();

	@Override
	protected byte[] out( byte[] input )
	{
		final byte A = input[ INPUT_COL_A ];
		final byte B = input[ INPUT_COL_B ];

		return new byte[]{ not.out( or.out( A, B ) ) };
	}
}