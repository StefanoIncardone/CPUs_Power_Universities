package com.stefano.components.logicGates.doubleInput;

public class OR extends DoubleInputLogicGate
{
	@Override
	public int[] out( int[] input )
	{
		final int A = input[ INPUT_COL_A ];
		final int B = input[ INPUT_COL_B ];

		return new int[]{ (A == 1) ? 1 : (B == 1) ? 1 : 0 };
	}
}