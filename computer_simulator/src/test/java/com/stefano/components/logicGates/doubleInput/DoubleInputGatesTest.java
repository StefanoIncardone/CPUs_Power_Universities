package com.stefano.components.logicGates.doubleInput;

import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleInputGatesTest 
{
	@Test
	public void ORgateShouldReturnZeroOnlyWhenBothInputsAreZero()
	{
		assertEquals( 0, OR.out( 0, 0 ) );
		assertEquals( 1, OR.out( 0, 1 ) );
		assertEquals( 1, OR.out( 1, 0 ) );
		assertEquals( 1, OR.out( 1, 1 ) );
	}

	@Test
	public void NORgateShouldReturnOneOnlyWhenBothInputsAreZero()
	{
		assertEquals( 1, NOR.out( 0, 0 ) );
		assertEquals( 0, NOR.out( 0, 1 ) );
		assertEquals( 0, NOR.out( 1, 0 ) );
		assertEquals( 0, NOR.out( 1, 1 ) );
	}

	@Test
	public void XORgateShouldReturnZeroWhenInputsAreTheSame()
	{
		assertEquals( 0, XOR.out( 0, 0 ) );
		assertEquals( 1, XOR.out( 0, 1 ) );
		assertEquals( 1, XOR.out( 1, 0 ) );
		assertEquals( 0, XOR.out( 1, 1 ) );
	}

	@Test
	public void XNORgateShouldReturnOneWhenInputsAreTheSame()
	{
		assertEquals( 1, XNOR.out( 0, 0 ) );
		assertEquals( 0, XNOR.out( 0, 1 ) );
		assertEquals( 0, XNOR.out( 1, 0 ) );
		assertEquals( 1, XNOR.out( 1, 1 ) );
	}

	@Test
	public void ANDgateShouldReturnOneOnlyWhenBothInputsAreOne()
	{
		assertEquals( 0, AND.out( 0, 0 ) );
		assertEquals( 0, AND.out( 0, 1 ) );
		assertEquals( 0, AND.out( 1, 0 ) );
		assertEquals( 1, AND.out( 1, 1 ) );
	}

	@Test
	public void NANDgateShouldReturnZeroOnlyWhenBothInputsAreOne()
	{
		assertEquals( 1, NAND.out( 0, 0 ) );
		assertEquals( 1, NAND.out( 0, 1 ) );
		assertEquals( 1, NAND.out( 1, 0 ) );
		assertEquals( 0, NAND.out( 1, 1 ) );
	}

	@Test
	public void IMPLYgateShouldReturnZeroOnlyWhenFirstInputIsOneAndSecondInputIsZero()
	{
		assertEquals( 1, IMPLY.out( 0, 0 ) );
		assertEquals( 1, IMPLY.out( 0, 1 ) );
		assertEquals( 0, IMPLY.out( 1, 0 ) );
		assertEquals( 1, IMPLY.out( 1, 1 ) );
	}

	@Test
	public void NIMPLYgateShouldReturnOneOnlyWhenFirstInputIsOneAndSecondInputIsZero()
	{
		assertEquals( 0, NIMPLY.out( 0, 0 ) );
		assertEquals( 0, NIMPLY.out( 0, 1 ) );
		assertEquals( 1, NIMPLY.out( 1, 0 ) );
		assertEquals( 0, NIMPLY.out( 1, 1 ) );
	}
}
