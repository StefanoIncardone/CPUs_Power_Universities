package com.stefano.components.logicGates.singleInput;

public abstract class TAUTOLOGY extends SingleInputGate
{
	public static int out( int A )
	{
		return (A == 1) ? 1 : 1;
	}
}