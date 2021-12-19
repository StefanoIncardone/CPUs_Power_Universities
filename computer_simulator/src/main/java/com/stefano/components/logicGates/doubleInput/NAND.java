package com.stefano.components.logicGates.doubleInput;

import com.stefano.components.logicGates.singleInput.NOT;

public class NAND extends DoubleInputLogicGate
{
	private final NOT not = new NOT();
	private final AND and = new AND();

	@Override
	public int out( int A, int B )
	{
		return not.out( and.out( A , B ) );
	}
}