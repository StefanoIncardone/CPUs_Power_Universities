package com.stefano.components.logicGates.doubleInput;

public class XOR extends DoubleInputGate
{
	private final OR or = new OR();
	private final NIMPLY nimply = new NIMPLY();

	@Override
	public int out( int A, int B )
	{
		return or.out( nimply.out( A, B ), nimply.out( B, A ) );
	}
}