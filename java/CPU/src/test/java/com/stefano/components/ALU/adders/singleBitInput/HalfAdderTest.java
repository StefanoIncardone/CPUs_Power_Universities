package com.stefano.components.ALU.adders.singleBitInput;

import static org.junit.Assert.*;

import com.stefano.components.ALU.adders.singleBitInput.half.HalfAdder;

import org.junit.Test;

public class HalfAdderTest
{
	private final HalfAdder halfAdder = new HalfAdder();

	@Test
	public void halfAdderShouldOutputZeroWhenBothInputsAreEqual()
	{
		assertEquals( 0, halfAdder.out( 0, 0 )[ Adder.SUM ] );
		assertEquals( 0, halfAdder.out( 1, 1 )[ Adder.SUM ] );
	}

	@Test
	public void halfAdderShouldOutputOneWhenInputsAreNotEqual()
	{
		assertEquals( 1, halfAdder.out( 0, 1 )[ Adder.SUM ] );
		assertEquals( 1, halfAdder.out( 1, 0 )[ Adder.SUM ] );
	}

	@Test
	public void halfAdderShouldSetCarryWhenInputsAreOne()
	{
		assertEquals( 1, halfAdder.out( 1, 1 )[ Adder.CARRY ] );
	}

	@Test
	public void halfAdderShouldNotSetCarryWhenInputsAreDifferent()
	{
		assertEquals( 0, halfAdder.out( 0, 1 )[ Adder.CARRY ] );
		assertEquals( 0, halfAdder.out( 1, 0 )[ Adder.CARRY ] );
	}
}