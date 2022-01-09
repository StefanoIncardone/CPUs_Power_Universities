package com.CPU.components.logicGates.gates.oneBitInput;

public final class BUFFER extends OneInputLogicGate
{
	public BUFFER()
	{
		super( BUFFER.class.getSimpleName() );
	}

	@Override
	protected byte[] out( byte[] input )
	{
		byte A = input[ INPUT_COL ];

		return new byte[]{ A };
	}
}