package com.stefano.components.logicGates.singleInput;

public class TAUTOLOGY extends SingleInputGate
{
	@Override
	public int out( int A )
	{
		return (A == 1) ? 1 : 1;
	}
}