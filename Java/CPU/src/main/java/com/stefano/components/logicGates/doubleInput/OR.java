package com.stefano.components.logicGates.doubleInput;

public class OR extends TwoInputLogicGate
{
	@Override
	protected byte[] out( byte[] input )
	{
		final byte A = input[ INPUT_COL_A ];
		final byte B = input[ INPUT_COL_B ];

		return new byte[]{ (byte) ((A == 1) ? 1 : (B == 1) ? 1 : 0) };
	}
}