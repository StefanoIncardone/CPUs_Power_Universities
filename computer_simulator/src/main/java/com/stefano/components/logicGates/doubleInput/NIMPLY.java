package com.stefano.components.logicGates.doubleInput;

import com.stefano.components.logicGates.singleInput.*;

public abstract class NIMPLY extends DoubleInputGate
{
	public static int out( int A, int B )
	{
		return AND.out( A, NOT.out( B ) );
	}
}