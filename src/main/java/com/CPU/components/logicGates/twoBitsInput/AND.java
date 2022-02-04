package com.CPU.components.logicGates.twoBitsInput;

public final class AND extends TwoInputLogicGate
{
	public AND()
	{
		super( AND.class );
	}
	
	@Override
	public byte[] out( byte... inputs )
	{
		validateInput( inputs );

		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ (byte) ((A == 1) ? (B == 1) ? 1 : 0 : 0) };
	}
}