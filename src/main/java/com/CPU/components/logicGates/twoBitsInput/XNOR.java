package com.CPU.components.logicGates.twoBitsInput;

import com.CPU.components.logicGates.oneBitInput.NOT;

public final class XNOR extends TwoInputLogicGate
{
	private final NOT not = new NOT();
	private final XOR xor = new XOR();
	
	public XNOR()
	{
		super( XNOR.class.getSimpleName() );
	}
	
	@Override
	public byte[] out( byte... inputs )
	{
		validateInput( inputs );

		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ not.out( xor.out( A, B ) ) };
	}
}