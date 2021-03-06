package com.CPU.components.logicGates.twoBitsInput;

public final class XOR extends TwoInputLogicGate
{
	private final OR or = new OR();
	private final NIMPLY nimply = new NIMPLY();
	private final CNIMPLY cnimply = new CNIMPLY();

	public XOR()
	{
		super( XOR.class );
	}
	
	@Override
	public byte[] out( byte... inputs )
	{
		validateInput( inputs );

		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		return new byte[]{ or.out( nimply.out( A, B ), cnimply.out( A, B ) ) };
	}
}