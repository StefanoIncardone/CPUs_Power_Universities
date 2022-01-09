package com.CPU.components.logicGates.gates.twoBitsInput;

public final class OR extends TwoInputLogicGate
{
	public OR()
	{
		super( OR.class.getSimpleName() );
	}
	
	@Override
	protected byte[] out( byte[] inputs )
	{
		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ (byte) ((A == 1) ? 1 : (B == 1) ? 1 : 0) };
	}
}