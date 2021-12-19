package com.stefano.components.logicGates.singleInput;

public class BUFFER extends SingleInputLogicGate
{
	@Override
	public int out( int A )
	{
		return A;
	}
}