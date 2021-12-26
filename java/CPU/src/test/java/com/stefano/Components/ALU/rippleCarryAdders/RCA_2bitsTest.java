package com.stefano.Components.ALU.rippleCarryAdders;

import static org.junit.Assert.*;

import com.stefano.components.ALU.adders.multipleBitInputs.rippleCarry.bits_2.RCA_2bits;

import org.junit.Test;

public class RCA_2bitsTest
{
	private final RCA_2bits rca_2 = new RCA_2bits();

	@Test
	public void twoBitsRCAShouldNotSetCarryIfSumIsLessThanThree()
	{
		assertEquals( 0, rca_2.out( 0, 0, 0, 0 )[ RCA_2bits.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 0, 0, 1 )[ RCA_2bits.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 1, 0, 0 )[ RCA_2bits.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 0, 1, 0 )[ RCA_2bits.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 1, 0, 0, 0 )[ RCA_2bits.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 0, 1, 1 )[ RCA_2bits.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 1, 1, 0, 0 )[ RCA_2bits.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 1, 0, 1 )[ RCA_2bits.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 1, 0, 0, 1 )[ RCA_2bits.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 1, 1, 0 )[ RCA_2bits.CARRY_OUT ] );
	}

	@Test
	public void twoBitsRCAShouldSetCarryIfSumIsMoreThanThree()
	{
		assertEquals( 1, rca_2.out( 1, 0, 1, 0 )[ RCA_2bits.CARRY_OUT ] );
		assertEquals( 1, rca_2.out( 0, 1, 1, 1 )[ RCA_2bits.CARRY_OUT ] );
		assertEquals( 1, rca_2.out( 1, 1, 0, 1 )[ RCA_2bits.CARRY_OUT ] );
		assertEquals( 1, rca_2.out( 1, 0, 1, 1 )[ RCA_2bits.CARRY_OUT ] );
		assertEquals( 1, rca_2.out( 1, 1, 1, 0 )[ RCA_2bits.CARRY_OUT ] );
		assertEquals( 1, rca_2.out( 1, 1, 1, 1 )[ RCA_2bits.CARRY_OUT ] );
	}

	@Test
	public void twoBitsRCAShouldOutputZeroWhenInputIsZero()
	{
		assertArrayEquals( new byte[]{ 0, 0, 0 }, rca_2.out( 0, 0, 0, 0 ) );
	}
}