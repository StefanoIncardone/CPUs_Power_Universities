package com.stefano.components.logicGates.twoBitsInput;

public class CIMPLY extends TwoInputLogicGate
{
	private final IMPLY imply = new IMPLY();

	@Override
	protected byte[] out( byte[] inputs )
	{
		final byte A = inputs[ INPUT_COL_A ];
		final byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ imply.out( B, A ) };
	}
}