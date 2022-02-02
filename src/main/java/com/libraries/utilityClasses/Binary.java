package com.libraries.utilityClasses;

import com.libraries.exceptions.NonBinaryInputException;

public final class Binary extends UtilityClass
{
	private static final int ASCII_NUMBER_OFFSET = 48;

	// suppress default constructor for non-instantiability
	private Binary()
	{
		super( Binary.class );
	}

	public static String toString( byte[] bits )
	{
		if( !isValid( bits ) )
		{
			throw new NonBinaryInputException();
		}
		else
		{
			return ArrayUtils.toStringConcat( bits );
		}
	}

	public static int toInteger( byte... bits )
	{

		return Integer.valueOf( toString( bits ), 2 );
	}

	public static byte[] toBitsArray( int value, int numberOfBits )
	{
		return applyASCIINumbersOffset
		(
			String.format( "%" + numberOfBits + "s", Integer.toBinaryString( value ) ).replace( ' ', '0' ).getBytes()
		);
	}

	private static byte[] applyASCIINumbersOffset( byte[] bits )
	{
		for( int index = 0; index < bits.length; index++ )
		{
			bits[ index ] -= ASCII_NUMBER_OFFSET;
		}

		return bits;
	}

	public static boolean isValid( byte[] input )
	{
		for( byte bit : input )
		{
			if( bit != 0 && bit != 1 )
			{
				return false;
			}
		}

		return true;
	}
}