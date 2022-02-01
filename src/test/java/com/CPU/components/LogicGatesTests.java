package com.CPU.components;

import static org.junit.Assert.assertEquals;

import com.CPU.components.logicGates.oneBitInput.*;
import com.CPU.components.logicGates.twoBitsInput.*;

import org.junit.Test;

public class LogicGatesTests
{
	private final TAUTOLOGY tautology = new TAUTOLOGY();
	private final CONTRADICTION contradiction = new CONTRADICTION();
	private final BUFFER buffer = new BUFFER();
	private final NOT not = new NOT();
	private final OR or = new OR();
	private final NOR nor = new NOR();
	private final XOR xor = new XOR();
	private final XNOR xnor = new XNOR();
	private final AND and = new AND();
	private final NAND nand = new NAND();
	private final IMPLY imply = new IMPLY();
	private final NIMPLY nimply = new NIMPLY();
	private final CIMPLY cimply = new CIMPLY();
	private final CNIMPLY cnimply = new CNIMPLY();

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

	@Test
	public void CIMPLYgateShouldReturnZeroOnlyWhenFirstInputIsZeroAndSecondInputIsOne()
	{
		assertEquals( 1, cimply.out( 0, 0 ) );
		assertEquals( 0, cimply.out( 0, 1 ) );
		assertEquals( 1, cimply.out( 1, 0 ) );
		assertEquals( 1, cimply.out( 1, 1 ) );
	}

	@Test
	public void CNIMPLYgateShouldReturnOneOnlyWhenFirstInputIsZeroAndSecondInputIsOne()
	{
		assertEquals( 0, cnimply.out( 0, 0 ) );
		assertEquals( 1, cnimply.out( 0, 1 ) );
		assertEquals( 0, cnimply.out( 1, 0 ) );
		assertEquals( 0, cnimply.out( 1, 1 ) );
	}
}
