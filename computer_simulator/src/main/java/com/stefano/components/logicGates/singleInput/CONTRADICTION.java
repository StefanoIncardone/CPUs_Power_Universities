package com.stefano.components.logicGates.singleInput;

public abstract class CONTRADICTION extends SingleInputGate
{
	public static int out( int A )
	{
		return (A == 0) ? 0 : 0;
	}
}