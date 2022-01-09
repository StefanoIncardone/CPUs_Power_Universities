package com.stefano.components.ALU.comparators.oneBit;

import com.stefano.components.logicGates.gates.twoBitsInput.CNIMPLY;
import com.stefano.components.logicGates.gates.twoBitsInput.IMPLY;
import com.stefano.components.logicGates.gates.twoBitsInput.XNOR;
import com.stefano.components.logicGates.gates.twoBitsInput.CIMPLY;
import com.stefano.components.logicGates.gates.twoBitsInput.NIMPLY;

public final class OneBitComparator extends AbstractOneBitComparator
{
	private final CNIMPLY cnimply = new CNIMPLY();
	private final IMPLY imply = new IMPLY();
	private final XNOR xnor = new XNOR();
	private final CIMPLY cimply = new CIMPLY();
	private final NIMPLY nimply = new NIMPLY();

	@Override
	protected byte[] out( byte[] input )
	{
		byte A = input[ INPUT_COL_A ];
		byte B = input[ INPUT_COL_B ];

		byte lessOutput = cnimply.out( A, B );
		byte lessOrEqualOutput = imply.out( A, B );
		byte equalOutput = xnor.out( A, B );
		byte greaterOrEqualOutput = cimply.out( A, B );
		byte greaterOutput = nimply.out( A, B );

		return new byte[]
		{
			lessOutput,
			lessOrEqualOutput,
			equalOutput,
			greaterOrEqualOutput,
			greaterOutput
		};
	}
}
