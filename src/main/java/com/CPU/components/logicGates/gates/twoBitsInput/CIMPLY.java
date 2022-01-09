package com.CPU.components.logicGates.gates.twoBitsInput;

public final class CIMPLY extends TwoInputLogicGate
{
	private final IMPLY imply = new IMPLY();

	public CIMPLY()
	{
		super( CIMPLY.class.getSimpleName() );
	}
	
	@Override
	protected byte[] out( byte[] inputs )
	{
		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ imply.out( B, A ) };
	}
}