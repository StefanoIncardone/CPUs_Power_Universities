package com.stefano.components.logicGates.gates.twoBitsInput;

import com.stefano.components.logicGates.gates.oneBitInput.NOT;

public final class NIMPLY extends TwoInputLogicGate
{
	private final AND and = new AND();
	private final NOT not = new NOT();

	public NIMPLY()
	{
		super( NIMPLY.class.getSimpleName() );
	}
	
	@Override
	protected byte[] out( byte[] inputs )
	{
		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ and.out( A, not.out( B ) ) };
	}
}