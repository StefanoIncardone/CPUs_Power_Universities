package com.stefano.components.logicGates.singleInput;

public class NOT extends SingleInputLogicGate
{
	@Override
	public int out( int A )
	{
		return (A == 1) ? 0 : 1;
	}
}