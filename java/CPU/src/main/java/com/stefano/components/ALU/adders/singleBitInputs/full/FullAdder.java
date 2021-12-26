package com.stefano.components.ALU.adders.singleBitInputs.full;

import com.stefano.components.ALU.adders.singleBitInputs.half.HalfAdder;
import com.stefano.components.logicGates.doubleInput.OR;

public class FullAdder extends AbstractFullAdder
{
	private final HalfAdder firstHalfAdder = new HalfAdder();
	private final HalfAdder secondHalfAdder = new HalfAdder();
	private final OR or = new OR();

	@Override
	protected byte[] out( byte[] input )
	{
		final byte C = input[ IMPUT_COL_CARRY ];
		final byte A = input[ INPUT_COL_A ];
		final byte B = input[ INPUT_COL_B ];

		byte[] firstHalfAdderOutput = firstHalfAdder.out( A, B );
		byte[] secondHalfAdderOutput = secondHalfAdder.out( firstHalfAdderOutput[ SUM ], C );
		byte carryOutput = or.out( firstHalfAdderOutput[ CARRY ], secondHalfAdderOutput[ CARRY ] );
	
		return new byte[]{ carryOutput, secondHalfAdderOutput[ SUM ] };
	}
}
