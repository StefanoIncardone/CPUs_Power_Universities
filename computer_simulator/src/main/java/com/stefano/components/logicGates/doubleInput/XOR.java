package com.stefano.components.logicGates.doubleInput;

public abstract class XOR extends DoubleInputGate
{
	public static int out( int A, int B )
	{
		return OR.out( NIMPLY.out( A, B ), NIMPLY.out( B, A ) );
	}
}