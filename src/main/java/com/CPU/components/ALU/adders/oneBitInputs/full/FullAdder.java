package com.CPU.components.ALU.adders.oneBitInputs.full;

import com.CPU.components.ALU.adders.oneBitInputs.half.HalfAdder;
import com.CPU.components.logicGates.twoBitsInput.OR;

public final class FullAdder extends AbstractFullAdder
{
	private final HalfAdder halfAdder_0 = new HalfAdder();
	private final HalfAdder halfAdder_1 = new HalfAdder();
	private final OR or = new OR();

	@Override
	protected byte[] out( byte... inputs )
	{
		validateInput( inputs );

		byte C = inputs[ IMPUT_COL_CARRY ];
		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		byte[] firstHalfAdderOutput = halfAdder_0.out( A, B );
		byte[] secondHalfAdderOutput = halfAdder_1.out( firstHalfAdderOutput[ SUM ], C );
		byte carryOutput = or.out( firstHalfAdderOutput[ CARRY_OUT ], secondHalfAdderOutput[ CARRY_OUT ] );
	
		return new byte[]{ carryOutput, secondHalfAdderOutput[ SUM ] };
	}
}
