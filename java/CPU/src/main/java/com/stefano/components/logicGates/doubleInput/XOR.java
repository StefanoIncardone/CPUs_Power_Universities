package com.stefano.components.logicGates.doubleInput;

public class XOR extends TwoInputLogicGate
{
	private final OR or = new OR();
	private final NIMPLY nimply = new NIMPLY();
	private final CNIMPLY cnimply = new CNIMPLY();

	@Override
	protected byte[] out( byte[] input )
	{
		final byte A = input[ INPUT_COL_A ];
		final byte B = input[ INPUT_COL_B ];

		return new byte[]{ or.out( nimply.out( A, B ), cnimply.out( A, B ) ) };
	}
}