package com.stefano.components.logicGates.singleInput;

public class BUFFER extends SingleInputLogicGate
{
	@Override
	public int[] out( int[] input )
	{
		final int A = input[ INPUT_COL ];

		return new int[]{ A };
	}
}