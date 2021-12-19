package com.stefano.components.logicGates.doubleInput;

import com.stefano.components.logicGates.singleInput.NOT;

public class XNOR extends DoubleInputLogicGate
{
	private final NOT not = new NOT();
	private final XOR xor = new XOR();
	
	@Override
	public int[] out( int[] input )
	{
		return not.out( xor.out( input ) );
	}
}