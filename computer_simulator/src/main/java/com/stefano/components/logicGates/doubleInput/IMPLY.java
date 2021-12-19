package com.stefano.components.logicGates.doubleInput;

import com.stefano.components.logicGates.singleInput.*;

public class IMPLY extends DoubleInputGate
{
	private final OR or = new OR();
	private final NOT not = new NOT();

	@Override
	public int out( int A, int B )
	{
		return or.out( not.out( A ), B );
	}
}