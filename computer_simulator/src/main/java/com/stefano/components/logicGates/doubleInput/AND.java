package com.stefano.components.logicGates.doubleInput;

public class AND extends DoubleInputLogicGate
{
	@Override
	public int out( int A, int B )
	{
		return (A == 1) ? (B == 1) ? 1 : 0 : 0;
	}
}