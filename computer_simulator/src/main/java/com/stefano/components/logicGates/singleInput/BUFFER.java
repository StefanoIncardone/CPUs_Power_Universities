package com.stefano.components.logicGates.singleInput;

public class BUFFER extends SingleInputGate
{
	@Override
	public int out( int A )
	{
		return A;
	}
}