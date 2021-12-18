package com.stefano.components.logicGates.doubleInput;

import com.stefano.components.logicGates.singleInput.*;

public abstract class NOR extends DoubleInputGate
{
	public static int out( int A, int B )
	{
		return NOT.out( OR.out( A, B ) );
	}
}