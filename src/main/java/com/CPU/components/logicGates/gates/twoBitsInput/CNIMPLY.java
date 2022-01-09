package com.CPU.components.logicGates.gates.twoBitsInput;

public final class CNIMPLY extends TwoInputLogicGate
{
	private final NIMPLY nimply = new NIMPLY();

	public CNIMPLY()
	{
		super( CNIMPLY.class.getSimpleName() );
	}
	
	@Override
	protected byte[] out( byte[] inputs )
	{
		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ nimply.out( B, A ) };
	}
}