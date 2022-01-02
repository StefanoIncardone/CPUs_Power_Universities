package com.stefano.components.logicGates.oneBitInput;

public class NOT extends OneInputLogicGate
{
	@Override
	protected byte[] out( byte[] input )
	{
		final byte A = input[ INPUT_COL ];

		return new byte[]{ (byte) ((A == 1) ? 0 : 1) };
	}
}