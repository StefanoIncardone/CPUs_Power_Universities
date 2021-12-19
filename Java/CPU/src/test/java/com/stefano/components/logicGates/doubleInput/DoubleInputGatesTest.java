package com.stefano.components.logicGates.doubleInput;

import static org.junit.Assert.*;

import com.stefano.components.logicGates.LogicGate;

import org.junit.Test;

public class DoubleInputGatesTest 
{
	private final OR or = new OR();
	private final NOR nor = new NOR();
	private final XOR xor = new XOR();
	private final XNOR xnor = new XNOR();
	private final AND and = new AND();
	private final NAND nand = new NAND();
	private final IMPLY imply = new IMPLY();
	private final NIMPLY nimply = new NIMPLY();

	@Test
	public void ORgateShouldReturnZeroOnlyWhenBothInputsAreZero()
	{
		assertEquals( 0, or.out( new int[]{ 0, 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 1, or.out( new int[]{ 0, 1 } )[ LogicGate.OUTPUT ] );
		assertEquals( 1, or.out( new int[]{ 1, 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 1, or.out( new int[]{ 1, 1 } )[ LogicGate.OUTPUT ] );
	}

	@Test
	public void NORgateShouldReturnOneOnlyWhenBothInputsAreZero()
	{
		assertEquals( 1, nor.out( new int[]{ 0, 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 0, nor.out( new int[]{ 0, 1 } )[ LogicGate.OUTPUT ] );
		assertEquals( 0, nor.out( new int[]{ 1, 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 0, nor.out( new int[]{ 1, 1 } )[ LogicGate.OUTPUT ] );
	}

	@Test
	public void XORgateShouldReturnZeroWhenInputsAreTheSame()
	{
		assertEquals( 0, xor.out( new int[]{ 0, 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 1, xor.out( new int[]{ 0, 1 } )[ LogicGate.OUTPUT ] );
		assertEquals( 1, xor.out( new int[]{ 1, 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 0, xor.out( new int[]{ 1, 1 } )[ LogicGate.OUTPUT ] );
	}

	@Test
	public void XNORgateShouldReturnOneWhenInputsAreTheSame()
	{
		assertEquals( 1, xnor.out( new int[]{ 0, 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 0, xnor.out( new int[]{ 0, 1 } )[ LogicGate.OUTPUT ] );
		assertEquals( 0, xnor.out( new int[]{ 1, 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 1, xnor.out( new int[]{ 1, 1 } )[ LogicGate.OUTPUT ] );
	}

	@Test
	public void ANDgateShouldReturnOneOnlyWhenBothInputsAreOne()
	{
		assertEquals( 0, and.out( new int[]{ 0, 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 0, and.out( new int[]{ 0, 1 } )[ LogicGate.OUTPUT ] );
		assertEquals( 0, and.out( new int[]{ 1, 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 1, and.out( new int[]{ 1, 1 } )[ LogicGate.OUTPUT ] );
	}

	@Test
	public void NANDgateShouldReturnZeroOnlyWhenBothInputsAreOne()
	{
		assertEquals( 1, nand.out( new int[]{ 0, 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 1, nand.out( new int[]{ 0, 1 } )[ LogicGate.OUTPUT ] );
		assertEquals( 1, nand.out( new int[]{ 1, 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 0, nand.out( new int[]{ 1, 1 } )[ LogicGate.OUTPUT ] );
	}

	@Test
	public void IMPLYgateShouldReturnZeroOnlyWhenFirstInputIsOneAndSecondInputIsZero()
	{
		assertEquals( 1, imply.out( new int[]{ 0, 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 1, imply.out( new int[]{ 0, 1 } )[ LogicGate.OUTPUT ] );
		assertEquals( 0, imply.out( new int[]{ 1, 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 1, imply.out( new int[]{ 1, 1 } )[ LogicGate.OUTPUT ] );
	}

	@Test
	public void NIMPLYgateShouldReturnOneOnlyWhenFirstInputIsOneAndSecondInputIsZero()
	{
		assertEquals( 0, nimply.out( new int[]{ 0, 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 0, nimply.out( new int[]{ 0, 1 } )[ LogicGate.OUTPUT ] );
		assertEquals( 1, nimply.out( new int[]{ 1, 0 } )[ LogicGate.OUTPUT ] );
		assertEquals( 0, nimply.out( new int[]{ 1, 1 } )[ LogicGate.OUTPUT ] );
	}
}
