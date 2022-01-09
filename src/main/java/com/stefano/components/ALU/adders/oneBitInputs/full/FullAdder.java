package com.stefano.components.ALU.adders.oneBitInputs.full;

import com.stefano.components.ALU.adders.oneBitInputs.half.HalfAdder;
import com.stefano.components.logicGates.gates.twoBitsInput.OR;

public final class FullAdder extends AbstractFullAdder
{
	private final HalfAdder firstHalfAdder = new HalfAdder();
	private final HalfAdder secondHalfAdder = new HalfAdder();
	private final OR or = new OR();

	@Override
	protected byte[] out( byte[] input )
	{
		byte C = input[ IMPUT_COL_CARRY ];
		byte A = input[ INPUT_COL_A ];
		byte B = input[ INPUT_COL_B ];

		byte[] firstHalfAdderOutput = firstHalfAdder.out( A, B );
		byte[] secondHalfAdderOutput = secondHalfAdder.out( firstHalfAdderOutput[ SUM ], C );
		byte carryOutput = or.out( firstHalfAdderOutput[ CARRY ], secondHalfAdderOutput[ CARRY ] );
	
		return new byte[]{ carryOutput, secondHalfAdderOutput[ SUM ] };
	}
}
