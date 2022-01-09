package com.stefano.components.ALU.adders.singleBitInput;

import static org.junit.Assert.*;

import com.stefano.components.ALU.adders.oneBitInputs.OneBitAdder;
import com.stefano.components.ALU.adders.oneBitInputs.half.HalfAdder;

import org.junit.Test;

public class HalfAdderTest
{
	private final HalfAdder halfAdder = new HalfAdder();

	@Test
	public void halfAdderShouldOutputZeroWhenBothInputsAreEqual()
	{
		assertEquals( 0, halfAdder.out( 0, 0 )[ OneBitAdder.SUM ] );
		assertEquals( 0, halfAdder.out( 1, 1 )[ OneBitAdder.SUM ] );
	}

	@Test
	public void halfAdderShouldOutputOneWhenInputsAreNotEqual()
	{
		assertEquals( 1, halfAdder.out( 0, 1 )[ OneBitAdder.SUM ] );
		assertEquals( 1, halfAdder.out( 1, 0 )[ OneBitAdder.SUM ] );
	}

	@Test
	public void halfAdderShouldSetCarryWhenInputsAreOne()
	{
		assertEquals( 1, halfAdder.out( 1, 1 )[ OneBitAdder.CARRY ] );
	}

	@Test
	public void halfAdderShouldNotSetCarryWhenInputsAreDifferent()
	{
		assertEquals( 0, halfAdder.out( 0, 1 )[ OneBitAdder.CARRY ] );
		assertEquals( 0, halfAdder.out( 1, 0 )[ OneBitAdder.CARRY ] );
	}
}