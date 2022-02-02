package com.CPU.components;

import static org.junit.Assert.*;

import com.CPU.components.ALU.multipliers.TwoBitMultiplier;
import com.libraries.utilityClasses.Binary;

import org.junit.Test;

public class MultipliersTests
{
	private final TwoBitMultiplier twoBitMultiplier = new TwoBitMultiplier();

	@Test
	public void twoBitMultiplierShouldProduceCorrectOutput()
	{
		for( int result = 0; result < Math.pow( 2, twoBitMultiplier.getNumberOfInputs() ); result++ )
		{
			byte[] bits = Binary.toBitsArray( result, twoBitMultiplier.getNumberOfInputs() );
			byte A1 = bits[ 0 ];
			byte A0 = bits[ 1 ];
			byte B1 = bits[ 2 ];
			byte B0 = bits[ 3 ];

			int value = Binary.toInteger( twoBitMultiplier.out( A1, A0, B1, B0 ) );
			int multiplicand_0 = Binary.toInteger( A1, A0 );
			int multiplicand_1 = Binary.toInteger( B1, B0 );
			int multiplication = multiplicand_0 * multiplicand_1;
			
			assertEquals( multiplication, value );
		}
	}
}
