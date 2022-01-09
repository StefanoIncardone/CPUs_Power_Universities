package com.CPU.components.logicGates.gates.oneBitInput;

public final class TAUTOLOGY extends OneInputLogicGate
{
	public TAUTOLOGY()
	{
		super( TAUTOLOGY.class.getSimpleName() );
	}

	@Override
	protected byte[] out( byte[] input )
	{
		return new byte[]{ 1 };
	}
}