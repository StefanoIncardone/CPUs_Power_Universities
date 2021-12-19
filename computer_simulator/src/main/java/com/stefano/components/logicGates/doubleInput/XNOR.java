package com.stefano.components.logicGates.doubleInput;

import com.stefano.components.logicGates.singleInput.*;

public class XNOR extends DoubleInputGate
{
	private final NOT not = new NOT();
	private final XOR xor = new XOR();
	
	@Override
	public int out( int A, int B )
	{
		return not.out( xor.out( A, B ) );
	}
}