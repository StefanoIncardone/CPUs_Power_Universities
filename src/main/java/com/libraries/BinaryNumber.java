package com.libraries;

import com.libraries.exceptions.BitLengthException;
import com.libraries.exceptions.NonBinaryNumberException;

public final class BinaryNumber
{
	private static final int ASCII_NUMBER_OFFSET = 48;

	private String value;

	public BinaryNumber( String number )
	{
		if( number.length() < 1 )
		{
			throw new BitLengthException( "the number contains no value" );
		}
		
		if( !isBinary( number ) )
		{
			throw new NonBinaryNumberException();
		}

		this.value = number;
	}

	public String toString()
	{
		return this.value;
	}

	public int toInteger()
	{
		return buildNumber( this.value );
	}

	private int buildNumber( byte... bits )
	{
		StringBuilder value = new StringBuilder();
		for( byte bit : bits )
		{
			value.append( bit );
		}

		return Integer.valueOf( value.toString(), 2 );
	}

	private int buildNumber( String number )
	{
		return buildNumber( number.getBytes() );
	}

	public byte[] toBitsArray( int value, int numberOfBits )
	{
		return applyASCIINumbersOffset
		(
			String.format( "%" + numberOfBits + "s", Integer.toBinaryString( value ) ).replace( ' ', '0' ).getBytes()
		);
	}

	private byte[] applyASCIINumbersOffset( byte[] bits )
	{
		for( int index = 0; index < bits.length; index++ )
		{
			bits[ index ] -= ASCII_NUMBER_OFFSET;
		}

		return bits;
	}

	public static boolean isBinary( byte[] bits )
	{
		for( byte bit : bits )
		{
			if( bit != 0 && bit != 1 )
			{
				return false;
			}
		}

		return true;
	}

	public static boolean isBinary( String number )
	{
		return isBinary( number.getBytes() );
	}
}
