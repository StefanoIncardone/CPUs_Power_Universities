package com.stefano.components.logicGates.singleInput;

public class CONTRADICTION extends SingleInputGate
{
	@Override
	public int out( int A )
	{
		return (A == 0) ? 0 : 0;
	}
}