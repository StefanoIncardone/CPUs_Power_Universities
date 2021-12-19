package com.stefano.components.math.adders;

import static org.junit.Assert.*;

import org.junit.Test;

public class HalfAdderTest
{
	private final HalfAdder halfAdder = new HalfAdder();

	@Test
	public void halfAdderShouldOutputZeroWhenBothInputsAreEqual()
	{
		assertEquals( 0, halfAdder.out( new int[]{ 0, 0 } )[ HalfAdder.SUM ] );
		assertEquals( 0, halfAdder.out( new int[]{ 1, 1 } )[ HalfAdder.SUM ] );
	}

	@Test
	public void halfAdderShouldOutputOneWhenInputsAreNotEqual()
	{
		assertEquals( 1, halfAdder.out( new int[]{ 0, 1 } )[ HalfAdder.SUM ] );
		assertEquals( 1, halfAdder.out( new int[]{ 1, 0 } )[ HalfAdder.SUM ] );
	}

	@Test
	public void halfAdderShouldSetCarryWhenInputsAreOne()
	{
		assertEquals( 1, halfAdder.out( new int[]{ 1, 1 } )[ HalfAdder.CARRY ] );
	}

	@Test
	public void halfAdderShouldNotSetCarryWhenInputsAreDifferent()
	{
		assertEquals( 0, halfAdder.out( new int[]{ 0, 1 } )[ HalfAdder.CARRY ] );
		assertEquals( 0, halfAdder.out( new int[]{ 1, 0 } )[ HalfAdder.CARRY ] );
	}
}