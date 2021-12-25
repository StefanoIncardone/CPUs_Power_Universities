package com.stefano.components.ALU.rippleCarryAdders;

import static org.junit.Assert.*;

import com.stefano.components.ALU.rippleCarryAdders.Bit_2.RCA_2;

import org.junit.Test;

public class RCA_2bitsTest
{
	private final RCA_2 rca_2 = new RCA_2();

	@Test
	public void twoBitsRCAShouldNotSetCarryIfSumIsLessThanThree()
	{
		assertEquals( 0, rca_2.out( 0, 0, 0, 0 )[ RCA_2.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 0, 0, 1 )[ RCA_2.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 1, 0, 0 )[ RCA_2.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 0, 1, 0 )[ RCA_2.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 1, 0, 0, 0 )[ RCA_2.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 0, 1, 1 )[ RCA_2.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 1, 1, 0, 0 )[ RCA_2.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 1, 0, 1 )[ RCA_2.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 1, 0, 0, 1 )[ RCA_2.CARRY_OUT ] );
		assertEquals( 0, rca_2.out( 0, 1, 1, 0 )[ RCA_2.CARRY_OUT ] );
	}

	@Test
	public void twoBitsRCAShouldSetCarryIfSumIsMoreThanThree()
	{
		assertEquals( 1, rca_2.out( 1, 0, 1, 0 )[ RCA_2.CARRY_OUT ] );
		assertEquals( 1, rca_2.out( 0, 1, 1, 1 )[ RCA_2.CARRY_OUT ] );
		assertEquals( 1, rca_2.out( 1, 1, 0, 1 )[ RCA_2.CARRY_OUT ] );
		assertEquals( 1, rca_2.out( 1, 0, 1, 1 )[ RCA_2.CARRY_OUT ] );
		assertEquals( 1, rca_2.out( 1, 1, 1, 0 )[ RCA_2.CARRY_OUT ] );
		assertEquals( 1, rca_2.out( 1, 1, 1, 1 )[ RCA_2.CARRY_OUT ] );
	}

	@Test
	public void twoBitsRCAShouldOutputZeroWhenInputIsZero()
	{
		assertArrayEquals( new byte[]{ 0, 0, 0 }, rca_2.out( 0, 0, 0, 0 ) );
	}
}