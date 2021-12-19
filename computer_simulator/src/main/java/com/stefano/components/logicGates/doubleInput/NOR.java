package com.stefano.components.logicGates.doubleInput;

import com.stefano.components.logicGates.singleInput.*;

public class NOR extends DoubleInputGate
{
	private final NOT not = new NOT();
	private final OR or = new OR();

	@Override
	public int out( int A, int B )
	{
		return not.out( or.out( A, B ) );
	}
}