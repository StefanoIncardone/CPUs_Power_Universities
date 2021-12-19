package com.stefano.components.math.adders;

import static org.junit.Assert.*;

import org.junit.Test;

public class FullAdderTest
{
	private final FullAdder fullAdder = new FullAdder();

	@Test
	public void fullAdderShouldOutputZeroWhenAllInputsAreZero()
	{
		assertEquals( 0, fullAdder.out( new int[]{ 0, 0, 0 } )[ HalfAdder.SUM ] );
	}

	@Test
	public void fullAdderShouldOutputOneWhenOnlyOneInputIsOne()
	{
		assertEquals( 1, fullAdder.out( new int[]{ 0, 0, 1 } )[ HalfAdder.SUM ] );
		assertEquals( 1, fullAdder.out( new int[]{ 0, 1, 0 } )[ HalfAdder.SUM ] );
		assertEquals( 1, fullAdder.out( new int[]{ 1, 0, 0 } )[ HalfAdder.SUM ] );
	}

	@Test
	public void fullAdderShouldOutputZeroWhenTwoInputsAreOne()
	{
		assertEquals( 0, fullAdder.out( new int[]{ 0, 1, 1 } )[ HalfAdder.SUM ] );
		assertEquals( 0, fullAdder.out( new int[]{ 1, 0, 1 } )[ HalfAdder.SUM ] );
		assertEquals( 0, fullAdder.out( new int[]{ 1, 1, 0 } )[ HalfAdder.SUM ] );
	}

	@Test
	public void fullAdderShouldOutputOneWhenAllInputsAreOne()
	{
		assertEquals( 1, fullAdder.out( new int[]{ 1, 1, 1 } )[ HalfAdder.SUM ] );
	}

	@Test
	public void fullAdderShouldNotSetCarryWhenOnlyOneInputsIsOne()
	{
		assertEquals( 0, fullAdder.out( new int[]{ 0, 0, 1 } )[ HalfAdder.CARRY ] );
		assertEquals( 0, fullAdder.out( new int[]{ 0, 1, 0 } )[ HalfAdder.CARRY ] );
		assertEquals( 0, fullAdder.out( new int[]{ 1, 0, 0 } )[ HalfAdder.CARRY ] );
	}

	@Test
	public void fullAdderShouldSetCarryWhenTwoInputsAreOne()
	{
		assertEquals( 1, fullAdder.out( new int[]{ 0, 1, 1 } )[ HalfAdder.CARRY ] );
		assertEquals( 1, fullAdder.out( new int[]{ 1, 0, 1 } )[ HalfAdder.CARRY ] );
		assertEquals( 1, fullAdder.out( new int[]{ 1, 1, 0 } )[ HalfAdder.CARRY ] );
	}

	@Test
	public void fullAdderShouldSetCarryWhenAllInputsAreOne()
	{
		assertEquals( 1, fullAdder.out( new int[]{ 1, 1, 1 } )[ HalfAdder.CARRY ] );
	}
}