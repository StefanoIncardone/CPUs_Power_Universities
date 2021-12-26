package com.stefano.components.logicGates.doubleInput;

import static org.junit.Assert.*;

import com.stefano.components.logicGates.twoBitsInput.AND;
import com.stefano.components.logicGates.twoBitsInput.IMPLY;
import com.stefano.components.logicGates.twoBitsInput.NAND;
import com.stefano.components.logicGates.twoBitsInput.NIMPLY;
import com.stefano.components.logicGates.twoBitsInput.NOR;
import com.stefano.components.logicGates.twoBitsInput.OR;
import com.stefano.components.logicGates.twoBitsInput.XNOR;
import com.stefano.components.logicGates.twoBitsInput.XOR;

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
		assertEquals( 0, or.out( 0, 0 ) );
		assertEquals( 1, or.out( 0, 1 ) );
		assertEquals( 1, or.out( 1, 0 ) );
		assertEquals( 1, or.out( 1, 1 ) );
	}

	@Test
	public void NORgateShouldReturnOneOnlyWhenBothInputsAreZero()
	{
		assertEquals( 1, nor.out( 0, 0 ) );
		assertEquals( 0, nor.out( 0, 1 ) );
		assertEquals( 0, nor.out( 1, 0 ) );
		assertEquals( 0, nor.out( 1, 1 ) );
	}

	@Test
	public void XORgateShouldReturnZeroWhenInputsAreTheSame()
	{
		assertEquals( 0, xor.out( 0, 0 ) );
		assertEquals( 1, xor.out( 0, 1 ) );
		assertEquals( 1, xor.out( 1, 0 ) );
		assertEquals( 0, xor.out( 1, 1 ) );
	}

	@Test
	public void XNORgateShouldReturnOneWhenInputsAreTheSame()
	{
		assertEquals( 1, xnor.out( 0, 0 ) );
		assertEquals( 0, xnor.out( 0, 1 ) );
		assertEquals( 0, xnor.out( 1, 0 ) );
		assertEquals( 1, xnor.out( 1, 1 ) );
	}

	@Test
	public void ANDgateShouldReturnOneOnlyWhenBothInputsAreOne()
	{
		assertEquals( 0, and.out( 0, 0 ) );
		assertEquals( 0, and.out( 0, 1 ) );
		assertEquals( 0, and.out( 1, 0 ) );
		assertEquals( 1, and.out( 1, 1 ) );
	}

	@Test
	public void NANDgateShouldReturnZeroOnlyWhenBothInputsAreOne()
	{
		assertEquals( 1, nand.out( 0, 0 ) );
		assertEquals( 1, nand.out( 0, 1 ) );
		assertEquals( 1, nand.out( 1, 0 ) );
		assertEquals( 0, nand.out( 1, 1 ) );
	}

	@Test
	public void IMPLYgateShouldReturnZeroOnlyWhenFirstInputIsOneAndSecondInputIsZero()
	{
		assertEquals( 1, imply.out( 0, 0 ) );
		assertEquals( 1, imply.out( 0, 1 ) );
		assertEquals( 0, imply.out( 1, 0 ) );
		assertEquals( 1, imply.out( 1, 1 ) );
	}

	@Test
	public void NIMPLYgateShouldReturnOneOnlyWhenFirstInputIsOneAndSecondInputIsZero()
	{
		assertEquals( 0, nimply.out( 0, 0 ) );
		assertEquals( 0, nimply.out( 0, 1 ) );
		assertEquals( 1, nimply.out( 1, 0 ) );
		assertEquals( 0, nimply.out( 1, 1 ) );
	}
}