package com.stefano.components.logicGates.doubleInput;

import com.stefano.components.logicGates.singleInput.*;

public class NIMPLY extends DoubleInputGate
{
	private final IMPLY imply = new IMPLY();
	private final NOT not = new NOT();

	@Override
	public int out( int A, int B )
	{
		return not.out( imply.out( A, B ));
	}
}