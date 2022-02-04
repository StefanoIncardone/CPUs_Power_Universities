package com.CPU.components.logicGates.oneBitInput;

public final class TAUTOLOGY extends OneInputLogicGate
{
	public TAUTOLOGY()
	{
		super( TAUTOLOGY.class );
	}

	@Override
	public byte[] out( byte... input )
	{
		validateInput( input );

		return new byte[]{ 1 };
	}
}