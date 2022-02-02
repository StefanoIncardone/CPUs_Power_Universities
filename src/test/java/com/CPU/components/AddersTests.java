package com.CPU.components;

import static org.junit.Assert.assertEquals;

import com.CPU.components.ALU.adders.multipleBitInputs.FourBitsRCA;
import com.CPU.components.ALU.adders.multipleBitInputs.TwoBitsRCA;
import com.CPU.components.ALU.adders.oneBitInputs.FullAdder;
import com.CPU.components.ALU.adders.oneBitInputs.HalfAdder;
import com.libraries.utilityClasses.Binary;

import org.junit.Test;

public class AddersTests
{
	private final HalfAdder halfAdder = new HalfAdder();
	private final FullAdder fullAdder = new FullAdder();
	private final TwoBitsRCA twoBitsRCA = new TwoBitsRCA();
	private final FourBitsRCA fourBitsRCA = new FourBitsRCA();

	@Test
	public void halfAdderShouldProduceCorrectOutput()
	{
		for( int result = 0; result < Math.pow( 2, halfAdder.getNumberOfInputs() ); result++ )
		{
			byte[] bits = Binary.toBitsArray( result, halfAdder.getNumberOfInputs() );
			byte A = bits[ 0 ];
			byte B = bits[ 1 ];

			int value = Binary.toInteger( halfAdder.out( A, B ) );
			
			assertEquals( A + B, value );
		}
	}

	@Test
	public void fullAdderShouldProduceCorrectOutput()
	{
		for( int result = 0; result < Math.pow( 2, fullAdder.getNumberOfInputs() ); result++ )
		{
			byte[] bits = Binary.toBitsArray( result, fullAdder.getNumberOfInputs() );
			byte C = bits[ 0 ];
			byte A = bits[ 1 ];
			byte B = bits[ 2 ];

			int value = Binary.toInteger( fullAdder.out( C, A, B ) );
			
			assertEquals( C + A + B, value );
		}
	}

	@Test
	public void twoBitRCAShouldProduceCorrectOutput()
	{
		for( int result = 0; result < Math.pow( 2, twoBitsRCA.getNumberOfInputs() ); result++ )
		{
			byte[] bits = Binary.toBitsArray( result, twoBitsRCA.getNumberOfInputs() );
			byte C = bits[ 0 ];
			byte A1 = bits[ 1 ];
			byte A0 = bits[ 2 ];
			byte B1 = bits[ 3 ];
			byte B0 = bits[ 4 ];

			int value = Binary.toInteger( twoBitsRCA.out( C, A1, A0, B1, B0 ) );
			int addend_0 = Binary.toInteger( A1, A0 );
			int addend_1 = Binary.toInteger( B1, B0 );
			
			assertEquals( C + addend_0 + addend_1, value );
		}
	}

	@Test
	public void fourBitRCAShouldProduceCorrectOutput()
	{
		for( int result = 0; result < Math.pow( 2, fourBitsRCA.getNumberOfInputs() ); result++ )
		{
			byte[] bits = Binary.toBitsArray( result, fourBitsRCA.getNumberOfInputs() );
			byte C = bits[ 0 ];
			byte A3 = bits[ 1 ];
			byte A2 = bits[ 2 ];
			byte A1 = bits[ 3 ];
			byte A0 = bits[ 4 ];
			byte B3 = bits[ 5 ];
			byte B2 = bits[ 6 ];
			byte B1 = bits[ 7 ];
			byte B0 = bits[ 8 ];

			int value = Binary.toInteger( fourBitsRCA.out( C, A3, A2, A1, A0, B3, B2, B1, B0 ) );
			int addend_0 = Binary.toInteger( A3, A2, A1, A0 );
			int addend_1 = Binary.toInteger( B3, B2, B1, B0 );
			
			assertEquals( C + addend_0 + addend_1, value );
		}
	}
}
