package com.stefano.components.ALU.adders.multipleBitsInput.rippleCarryAdders.twoBits;

import static org.junit.Assert.*;

import com.stefano.components.ALU.adders.multipleBitInputs.rippleCarry.RCA.twoBits.TwoBitsRCA;

import org.junit.Test;

public class RCA_2bitsTest
{
	private final TwoBitsRCA rca_2 = new TwoBitsRCA();

	@Test
	public void twoBitsRCAShouldNotSetCarryIfSumIsLessThanThree()
	{
		assertEquals( 0, rca_2.out( 0, 0, 0, 0 )[ TwoBitsRCA.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 0, 0, 1 )[ TwoBitsRCA.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 1, 0, 0 )[ TwoBitsRCA.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 0, 1, 0 )[ TwoBitsRCA.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 1, 0, 0, 0 )[ TwoBitsRCA.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 0, 1, 1 )[ TwoBitsRCA.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 1, 1, 0, 0 )[ TwoBitsRCA.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 1, 0, 1 )[ TwoBitsRCA.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 1, 0, 0, 1 )[ TwoBitsRCA.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 1, 1, 0 )[ TwoBitsRCA.CARRY_OUT ] );
	}

	@Test
	public void twoBitsRCAShouldSetCarryIfSumIsMoreThanThree()
	{
		assertEquals( 1, rca_2.out( 1, 0, 1, 0 )[ TwoBitsRCA.CARRY_OUT ] );
		assertEquals( 1, rca_2.out( 0, 1, 1, 1 )[ TwoBitsRCA.CARRY_OUT ] );
		assertEquals( 1, rca_2.out( 1, 1, 0, 1 )[ TwoBitsRCA.CARRY_OUT ] );
		assertEquals( 1, rca_2.out( 1, 0, 1, 1 )[ TwoBitsRCA.CARRY_OUT ] );
		assertEquals( 1, rca_2.out( 1, 1, 1, 0 )[ TwoBitsRCA.CARRY_OUT ] );
		assertEquals( 1, rca_2.out( 1, 1, 1, 1 )[ TwoBitsRCA.CARRY_OUT ] );
	}

	@Test
	public void twoBitsRCAShouldOutputZeroWhenInputIsZero()
	{
		assertArrayEquals( new byte[]{ 0, 0, 0 }, rca_2.out( 0, 0, 0, 0 ) );
	}
}