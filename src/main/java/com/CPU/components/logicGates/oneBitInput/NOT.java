package com.CPU.components.logicGates.oneBitInput;

public final class NOT extends OneInputLogicGate
{
	public NOT()
	{
		super( NOT.class );
	}

	@Override
	public byte[] out( byte... input )
	{
		validateInput( input );

		byte A = input[ INPUT_COL ];

		return new byte[]{ (byte) ((A == 1) ? 0 : 1) };
	}
}