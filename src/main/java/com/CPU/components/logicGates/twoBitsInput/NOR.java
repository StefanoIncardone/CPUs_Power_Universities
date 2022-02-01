package com.CPU.components.logicGates.twoBitsInput;

import com.CPU.components.logicGates.oneBitInput.NOT;

public final class NOR extends TwoInputLogicGate
{
	private final NOT not = new NOT();
	private final OR or = new OR();

	public NOR()
	{
		super( NOR.class.getSimpleName() );
	}
	
	@Override
	public byte[] out( byte... inputs )
	{
		validateInput( inputs );

		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ not.out( or.out( A, B ) ) };
	}
}