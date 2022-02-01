package com.CPU.components.logicGates.oneBitInput;

public final class CONTRADICTION extends OneInputLogicGate
{
	public CONTRADICTION()
	{
		super( CONTRADICTION.class.getSimpleName() );
	}

	@Override
	protected byte[] out( byte... input )
	{
		validateInput( input );

		return new byte[]{ 0 };
	}
}