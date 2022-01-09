package com.CPU.components.logicGates.gates.twoBitsInput;

public final class AND extends TwoInputLogicGate
{
	public AND()
	{
		super( AND.class.getSimpleName() );
	}
	
	@Override
	protected byte[] out( byte[] inputs )
	{
		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ (byte) ((A == 1) ? (B == 1) ? 1 : 0 : 0) };
	}
}