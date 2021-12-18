package com.stefano.components.logicGates.doubleInput;

public abstract class AND extends DoubleInputGate
{
	public static int out( int A, int B )
	{
		return (A == 1) ? (B == 1) ? 1 : 0 : 0;
	}
}