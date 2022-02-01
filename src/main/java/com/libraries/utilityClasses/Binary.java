package com.libraries.utilityClasses;

public final class Binary extends UtilityClass
{
	private static final int ASCI_NUMBER_OFFSET = 48;

	// suppress default constructor for non-instantiability
	private Binary()
	{
		super( Binary.class );
	}

	public static String toString( byte[] bits )
	{
		return ArrayUtils.toStringConcat( bits );
	}

	public static int toInteger( byte... bits )
	{
		return Integer.valueOf( toString( bits ), 2 );
	}

	public static byte[] toBitArray( int value, int numberOfBits )
	{
		return applyOffset
		(
			String.format( "%" + numberOfBits + "s", Integer.toBinaryString( value ) ).replace( ' ', '0' ).getBytes()
		);
	}

	private static byte[] applyOffset( byte[] bits )
	{
		for( int index = 0; index < bits.length; index++ )
		{
			bits[ index ] -= ASCI_NUMBER_OFFSET;
		}

		return bits;
	}

	public static boolean isValid( byte... input )
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

	public static void throwNonBinaryValuesError()
	{
		throw new IllegalArgumentException( "input contains non-binary values" );
	}
}