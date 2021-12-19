package com.stefano.components.logicGates.singleInput;

public class TAUTOLOGY extends OneInputLogicGate
{
	@Override
	public int[] out( int[] input )
	{
		final int A = input[ INPUT_COL ];

		return new int[]{ (A == 1) ? 1 : 1 };
	}
}