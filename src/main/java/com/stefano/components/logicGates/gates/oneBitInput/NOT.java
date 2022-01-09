package com.stefano.components.logicGates.gates.oneBitInput;

public final class NOT extends OneInputLogicGate
{
	public NOT()
	{
		super( NOT.class.getSimpleName() );
	}

	@Override
	protected byte[] out( byte[] input )
	{
		byte A = input[ INPUT_COL ];

		return new byte[]{ (byte) ((A == 1) ? 0 : 1) };
	}
}