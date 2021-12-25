package com.stefano.components.logicGates.singleInput;

public class BUFFER extends OneInputLogicGate
{
	@Override
	protected byte[] out( byte[] input )
	{
		final byte A = input[ INPUT_COL ];

		return new byte[]{ A };
	}
}