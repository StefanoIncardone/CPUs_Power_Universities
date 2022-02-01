package com.CPU.components.ALU.comparators.oneBit;

import com.CPU.components.logicGates.twoBitsInput.CIMPLY;
import com.CPU.components.logicGates.twoBitsInput.CNIMPLY;
import com.CPU.components.logicGates.twoBitsInput.IMPLY;
import com.CPU.components.logicGates.twoBitsInput.NIMPLY;
import com.CPU.components.logicGates.twoBitsInput.XNOR;

public final class OneBitComparator extends AbstractOneBitComparator
{
	private final CNIMPLY cnimply = new CNIMPLY();
	private final IMPLY imply = new IMPLY();
	private final XNOR xnor = new XNOR();
	private final CIMPLY cimply = new CIMPLY();
	private final NIMPLY nimply = new NIMPLY();

	@Override
	protected byte[] out( byte... inputs )
	{
		validateInput( inputs );

		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

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
