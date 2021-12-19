package com.stefano.components.logicGates.doubleInput;

import com.stefano.components.logicGates.singleInput.NOT;

public class NOR extends DoubleInputLogicGate
{
	private final NOT not = new NOT();
	private final OR or = new OR();

	@Override
	public int out( int A, int B )
	{
		return not.out( or.out( A, B ) );
	}
}