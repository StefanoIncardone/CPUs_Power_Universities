package com.stefano.components.logicGates.doubleInput;

import com.stefano.components.logicGates.singleInput.NOT;

public class NIMPLY extends TwoInputLogicGate
{
	private final IMPLY imply = new IMPLY();
	private final NOT not = new NOT();

	@Override
	public int[] out( int[] input )
	{
		return not.out( imply.out( input ));
	}
}