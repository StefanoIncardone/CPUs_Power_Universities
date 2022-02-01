package com.CPU.components.logicGates.twoBitsInput;

public final class CNIMPLY extends TwoInputLogicGate
{
	private final NIMPLY nimply = new NIMPLY();

	public CNIMPLY()
	{
		super( CNIMPLY.class.getSimpleName() );
	}
	
	@Override
	public byte[] out( byte... inputs )
	{
		validateInput( inputs );

		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ nimply.out( B, A ) };
	}
}