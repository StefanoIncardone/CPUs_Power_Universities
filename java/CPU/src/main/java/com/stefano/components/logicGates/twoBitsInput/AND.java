package com.stefano.components.logicGates.twoBitsInput;

public class AND extends TwoInputLogicGate
{
	@Override
	protected byte[] out( byte[] inputs )
	{
		final byte A = inputs[ INPUT_COL_A ];
		final byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ (byte) ((A == 1) ? (B == 1) ? 1 : 0 : 0) };
	}
}