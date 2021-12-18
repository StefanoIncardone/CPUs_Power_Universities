package com.stefano.components.logicGates.singleInput;

public abstract class NOT extends SingleInputGate
{
	public static int out( int A )
	{
		return (A == 1) ? 0 : 1;
	}
}