package com.stefano.components.ALU.comparators.oneBit;

import com.stefano.components.logicGates.doubleInput.CIMPLY;
import com.stefano.components.logicGates.doubleInput.CNIMPLY;
import com.stefano.components.logicGates.doubleInput.IMPLY;
import com.stefano.components.logicGates.doubleInput.NIMPLY;
import com.stefano.components.logicGates.doubleInput.XNOR;

public class OneBitComparator extends AbstractOneBitComparator
{
	final CNIMPLY cnimply = new CNIMPLY();
	final IMPLY imply = new IMPLY();
	final XNOR xnor = new XNOR();
	final CIMPLY cimply = new CIMPLY();
	final NIMPLY nimply = new NIMPLY();

	@Override
	protected byte[] out( byte[] input )
	{
		final byte A = input[ INPUT_COL_A ];
		final byte B = input[ INPUT_COL_B ];

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
