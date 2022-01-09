package com.CPU.components.ALU.comparators;

import static org.junit.Assert.*;

import com.CPU.components.ALU.comparators.oneBit.OneBitComparator;

import org.junit.Test;

public class OneBitComparatorTests
{
	private final OneBitComparator oneBitComparator = new OneBitComparator();

	@Test
	public void OneBitComparatorShouldOutputOneWhenTheFirstInputIsLessThanTheSecondInput()
	{
		assertEquals( 0, oneBitComparator.out( 0, 0 )[ Comparator.LESS ] );
		assertEquals( 1, oneBitComparator.out( 0, 1 )[ Comparator.LESS ] );
		assertEquals( 0, oneBitComparator.out( 1, 0 )[ Comparator.LESS ] );
		assertEquals( 0, oneBitComparator.out( 1, 1 )[ Comparator.LESS ] );
	}

	@Test
	public void OneBitComparatorShouldOutputOneWhenTheFirstInputIsLessOrEqualThanTheSecondInput()
	{
		assertEquals( 1, oneBitComparator.out( 0, 0 )[ Comparator.LESS_OR_EQUAL ] );
		assertEquals( 1, oneBitComparator.out( 0, 1 )[ Comparator.LESS_OR_EQUAL ] );
		assertEquals( 0, oneBitComparator.out( 1, 0 )[ Comparator.LESS_OR_EQUAL ] );
		assertEquals( 1, oneBitComparator.out( 1, 1 )[ Comparator.LESS_OR_EQUAL ] );
	}

	@Test
	public void OneBitComparatorShouldOutputOneWhenTheFirstInputIsEqualToTheSecondInput()
	{
		assertEquals( 1, oneBitComparator.out( 0, 0 )[ Comparator.EQUAL ] );
		assertEquals( 0, oneBitComparator.out( 0, 1 )[ Comparator.EQUAL ] );
		assertEquals( 0, oneBitComparator.out( 1, 0 )[ Comparator.EQUAL ] );
		assertEquals( 1, oneBitComparator.out( 1, 1 )[ Comparator.EQUAL ] );
	}

	@Test
	public void OneBitComparatorShouldOutputOneWhenTheFirstInputIsGreaterOrEqualThanTheSecondInput()
	{
		assertEquals( 1, oneBitComparator.out( 0, 0 )[ Comparator.GREATER_OR_EQUAL ] );
		assertEquals( 0, oneBitComparator.out( 0, 1 )[ Comparator.GREATER_OR_EQUAL ] );
		assertEquals( 1, oneBitComparator.out( 1, 0 )[ Comparator.GREATER_OR_EQUAL ] );
		assertEquals( 1, oneBitComparator.out( 1, 1 )[ Comparator.GREATER_OR_EQUAL ] );
	}

	@Test
	public void OneBitComparatorShouldOutputOneWhenTheFirstInputIsGreaterThanTheSecondInput()
	{
		assertEquals( 0, oneBitComparator.out( 0, 0 )[ Comparator.GREATER ] );
		assertEquals( 0, oneBitComparator.out( 0, 1 )[ Comparator.GREATER ] );
		assertEquals( 1, oneBitComparator.out( 1, 0 )[ Comparator.GREATER ] );
		assertEquals( 0, oneBitComparator.out( 1, 1 )[ Comparator.GREATER ] );
	}
}
