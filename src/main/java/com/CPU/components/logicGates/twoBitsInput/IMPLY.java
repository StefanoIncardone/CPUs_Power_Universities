package com.CPU.components.logicGates.twoBitsInput;

import com.CPU.components.logicGates.oneBitInput.NOT;

public final class IMPLY extends TwoInputLogicGate
{
	private final NIMPLY nimply = new NIMPLY();
	private final NOT not = new NOT();

	public IMPLY()
	{
		super( IMPLY.class );
	}
	
	@Override
	public byte[] out( byte... inputs )
	{
		validateInput( inputs );

		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ not.out( nimply.out( A , B ) ) };
	}
}