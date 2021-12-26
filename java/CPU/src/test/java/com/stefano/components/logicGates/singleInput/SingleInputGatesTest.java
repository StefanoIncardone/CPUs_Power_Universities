package com.stefano.components.logicGates.singleInput;

import static org.junit.Assert.*;

import org.junit.Test;

public class SingleInputGatesTest
{
	private final TAUTOLOGY tautology = new TAUTOLOGY();
	private final CONTRADICTION contradiction = new CONTRADICTION();
	private final BUFFER buffer = new BUFFER();
	private final NOT not = new NOT();

	@Test
	public void TAUTOLOGYgateShouldAlwaysReturnOne()
	{
		assertEquals( 1, tautology.out( 0 ) );
		assertEquals( 1, tautology.out( 1 ) );
	}

	@Test
	public void CONTRADICTIONgateShouldAlwaysReturnZero()
	{
		assertEquals( 0, contradiction.out( 0 ) );
		assertEquals( 0, contradiction.out( 1 ) );
	}

	@Test
	public void BUFFERgateShouldNotChangeInput()
	{
		assertEquals( 0, buffer.out( 0 ) );
		assertEquals( 1, buffer.out( 1 ) );
	}

	@Test
	public void NOTgateShouldInvertInput()
	{
		assertEquals( 1, not.out( 0 ) );
		assertEquals( 0, not.out( 1 ) );
	}
}
