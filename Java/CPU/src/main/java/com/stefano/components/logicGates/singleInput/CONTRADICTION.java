package com.stefano.components.logicGates.singleInput;

public class CONTRADICTION extends OneInputLogicGate
{
	@Override
	protected byte[] out( byte[] input )
	{
		final byte A = input[ INPUT_COL ];

		return new byte[]{ (byte) ((A == 0) ? 0 : 0) };
	}
}