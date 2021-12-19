package com.stefano.components.logicGates.singleInput;

public class CONTRADICTION extends OneInputLogicGate
{
	@Override
	public int[] out( int[] input )
	{
		final int A = input[ INPUT_COL ];

		return new int[]{ (A == 0) ? 0 : 0 };
	}
}