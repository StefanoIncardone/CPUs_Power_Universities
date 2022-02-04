package com.CPU.components.logicGates.oneBitInput;

public final class BUFFER extends OneInputLogicGate
{
	public BUFFER()
	{
		super( BUFFER.class );
	}

	@Override
	public byte[] out( byte... input )
	{
		validateInput( input );

		byte A = input[ INPUT_COL ];

		return new byte[]{ A };
	}
}