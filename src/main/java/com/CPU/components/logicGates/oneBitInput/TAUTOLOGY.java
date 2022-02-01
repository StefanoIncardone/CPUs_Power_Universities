package com.CPU.components.logicGates.oneBitInput;

public final class TAUTOLOGY extends OneInputLogicGate
{
	public TAUTOLOGY()
	{
		super( TAUTOLOGY.class.getSimpleName() );
	}

	@Override
	protected byte[] out( byte... input )
	{
		validateInput( input );

		return new byte[]{ 1 };
	}
}