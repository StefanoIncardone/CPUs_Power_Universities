package com.stefano.components.logicGates.singleInput;

import static org.junit.Assert.*;

import com.stefano.components.logicGates.LogicGate;

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
		assertEquals( 1, tautology.out( new int[]{ 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 1, tautology.out( new int[]{ 1 } )[ LogicGate.OUTPUT ] );
	}

	@Test
	public void CONTRADICTIONgateShouldAlwaysReturnZero()
	{
		assertEquals( 0, contradiction.out( new int[]{ 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 0, contradiction.out( new int[]{ 1 } )[ LogicGate.OUTPUT ] );
	}

	@Test
	public void BUFFERgateShouldNotChangeInput()
	{
		assertEquals( 0, buffer.out( new int[]{ 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 1, buffer.out( new int[]{ 1 } )[ LogicGate.OUTPUT ] );
	}

	@Test
	public void NOTgateShouldInvertInput()
	{
		assertEquals( 1, not.out( new int[]{ 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 0, not.out( new int[]{ 1 } )[ LogicGate.OUTPUT ] );
	}
}
