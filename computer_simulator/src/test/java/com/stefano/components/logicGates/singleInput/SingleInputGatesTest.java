package com.stefano.components.logicGates.singleInput;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingleInputGatesTest 
{
	@Test
	public void TAUTOLOGYgateShouldAlwaysReturnOne()
	{
		assertEquals( 1, TAUTOLOGY.out( 0 ) );
		assertEquals( 1, TAUTOLOGY.out( 1 ) );
	}

	@Test
	public void CONTRADICTIONgateShouldAlwaysReturnZero()
	{
		assertEquals( 0, CONTRADICTION.out( 0 ) );
		assertEquals( 0, CONTRADICTION.out( 1 ) );
	}

	@Test
	public void BUFFERgateShouldNotChangeInput()
	{
		assertEquals( 0, BUFFER.out( 0 ) );
		assertEquals( 1, BUFFER.out( 1 ) );
	}

	@Test
	public void NOTgateShouldInvertInput()
	{
		assertEquals( 1, NOT.out( 0 ) );
		assertEquals( 0, NOT.out( 1 ) );
	}
}
