package com.CPU.components.logicGates.twoBitsInput;

public final class CIMPLY extends TwoInputLogicGate
{
	private final IMPLY imply = new IMPLY();

	public CIMPLY()
	{
		super( CIMPLY.class );
	}
	
	@Override
	public byte[] out( byte... inputs )
	{
		validateInput( inputs );

		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ imply.out( B, A ) };
	}
}