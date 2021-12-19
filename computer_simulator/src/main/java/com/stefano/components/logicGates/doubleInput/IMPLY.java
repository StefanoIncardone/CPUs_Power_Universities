package com.stefano.components.logicGates.doubleInput;

import com.stefano.components.logicGates.singleInput.NOT;

public class IMPLY extends DoubleInputLogicGate
{
	private final OR or = new OR();
	private final NOT not = new NOT();

	@Override
	public int[] out( int[] input )
	{
		final int A = input[ INPUT_COL_A ];
		final int B = input[ INPUT_COL_B ];

		int not_A = not.out( new int[]{ A } )[ OUTPUT ];

		return or.out( new int[]{ not_A, B } );
	}
}