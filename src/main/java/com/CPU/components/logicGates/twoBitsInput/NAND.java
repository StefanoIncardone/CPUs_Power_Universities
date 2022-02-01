package com.CPU.components.logicGates.twoBitsInput;

import com.CPU.components.logicGates.oneBitInput.NOT;

public final class NAND extends TwoInputLogicGate
{
	private final NOT not = new NOT();
	private final AND and = new AND();

	public NAND()
	{
		super( NAND.class.getSimpleName() );
	}
	
	@Override
	public byte[] out( byte... inputs )
	{
		validateInput( inputs );

		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ not.out( and.out( A, B ) ) };
	}
}