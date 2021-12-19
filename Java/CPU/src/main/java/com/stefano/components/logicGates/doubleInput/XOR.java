package com.stefano.components.logicGates.doubleInput;

public class XOR extends TwoInputLogicGate
{
	private final OR or = new OR();
	private final NIMPLY nimply = new NIMPLY();

	@Override
	public int[] out( int[] input )
	{
		final int A = input[ INPUT_COL_A ];
		final int B = input[ INPUT_COL_B ];

		int nimply_AB = nimply.out( new int[]{ A, B } )[ OUTPUT ];
		int nimply_BA = nimply.out( new int[]{ B, A } )[ OUTPUT ];

		return or.out( new int[]{ nimply_AB, nimply_BA } );
	}
}