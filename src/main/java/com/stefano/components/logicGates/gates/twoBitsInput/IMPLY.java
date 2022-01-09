package com.stefano.components.logicGates.gates.twoBitsInput;

import com.stefano.components.logicGates.gates.oneBitInput.NOT;

public final class IMPLY extends TwoInputLogicGate
{
	private final NIMPLY nimply = new NIMPLY();
	private final NOT not = new NOT();

	public IMPLY()
	{
		super( IMPLY.class.getSimpleName() );
	}
	
	@Override
	protected byte[] out( byte[] inputs )
	{
		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ not.out( nimply.out( A , B ) ) };
	}
}