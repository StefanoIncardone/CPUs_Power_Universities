package com.stefano.components.ALU.adders.singleBitInput;

import static org.junit.Assert.*;

import com.stefano.components.ALU.adders.oneBitInputs.OneBitAdder;
import com.stefano.components.ALU.adders.oneBitInputs.full.FullAdder;

import org.junit.Test;

public class FullAdderTest
{
	private final FullAdder fullAdder = new FullAdder();

	@Test
	public void fullAdderShouldOutputZeroWhenAllInputsAreZero()
	{
		assertEquals( 0, fullAdder.out( 0, 0, 0 )[ OneBitAdder.SUM ] );
	}

	@Test
	public void fullAdderShouldOutputOneWhenOnlyOneInputIsOne()
	{
		assertEquals( 1, fullAdder.out( 0, 0, 1 )[ OneBitAdder.SUM ] );
		assertEquals( 1, fullAdder.out( 0, 1, 0 )[ OneBitAdder.SUM ] );
		assertEquals( 1, fullAdder.out( 1, 0, 0 )[ OneBitAdder.SUM ] );
	}

	@Test
	public void fullAdderShouldOutputZeroWhenTwoInputsAreOne()
	{
		assertEquals( 0, fullAdder.out( 0, 1, 1 )[ OneBitAdder.SUM ] );
		assertEquals( 0, fullAdder.out( 1, 0, 1 )[ OneBitAdder.SUM ] );
		assertEquals( 0, fullAdder.out( 1, 1, 0 )[ OneBitAdder.SUM ] );
	}

	@Test
	public void fullAdderShouldOutputOneWhenAllInputsAreOne()
	{
		assertEquals( 1, fullAdder.out( 1, 1, 1 )[ OneBitAdder.SUM ] );
	}

	@Test
	public void fullAdderShouldNotSetCarryWhenOnlyOneInputsIsOne()
	{
		assertEquals( 0, fullAdder.out( 0, 0, 1 )[ OneBitAdder.CARRY ] );
		assertEquals( 0, fullAdder.out( 0, 1, 0 )[ OneBitAdder.CARRY ] );
		assertEquals( 0, fullAdder.out( 1, 0, 0 )[ OneBitAdder.CARRY ] );
	}

	@Test
	public void fullAdderShouldSetCarryWhenTwoInputsAreOne()
	{
		assertEquals( 1, fullAdder.out( 0, 1, 1 )[ OneBitAdder.CARRY ] );
		assertEquals( 1, fullAdder.out( 1, 0, 1 )[ OneBitAdder.CARRY ] );
		assertEquals( 1, fullAdder.out( 1, 1, 0 )[ OneBitAdder.CARRY ] );
	}

	@Test
	public void fullAdderShouldSetCarryWhenAllInputsAreOne()
	{
		assertEquals( 1, fullAdder.out( 1, 1, 1 )[ OneBitAdder.CARRY ] );
	}
}