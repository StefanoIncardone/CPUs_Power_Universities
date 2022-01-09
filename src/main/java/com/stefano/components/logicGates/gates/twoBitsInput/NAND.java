package com.stefano.components.logicGates.gates.twoBitsInput;

import com.stefano.components.logicGates.gates.oneBitInput.NOT;

public final class NAND extends TwoInputLogicGate
{
	private final NOT not = new NOT();
	private final AND and = new AND();

	public NAND()
	{
		super( NAND.class.getSimpleName() );
	}
	
	@Override
	protected byte[] out( byte[] inputs )
	{
		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ not.out( and.out( A, B ) ) };
	}
}