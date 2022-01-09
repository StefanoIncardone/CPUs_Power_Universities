package com.CPU.components.logicGates.gates.twoBitsInput;

import com.CPU.components.logicGates.gates.oneBitInput.NOT;

public final class XNOR extends TwoInputLogicGate
{
	private final NOT not = new NOT();
	private final XOR xor = new XOR();
	
	public XNOR()
	{
		super( XNOR.class.getSimpleName() );
	}
	
	@Override
	protected byte[] out( byte[] inputs )
	{
		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ not.out( xor.out( A, B ) ) };
	}
}