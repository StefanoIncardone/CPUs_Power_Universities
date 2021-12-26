package com.stefano.components.logicGates.oneBitInput;

public class TAUTOLOGY extends OneInputLogicGate
{
	@Override
	protected byte[] out( byte[] input )
	{
		final byte A = input[ INPUT_COL ];

		return new byte[]{ (byte) ((A == 1) ? 1 : 1) };
	}
}