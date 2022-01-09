package com.libraries;

public final class Binary extends UtilityClass
{
	private static final int ASCI_NUMBER_OFFSET = 48;

	private Binary()
	{
		super( Binary.class );
	}

	public static byte[] toBitArray( int number, int numberOfBits )
	{
		return applyOffset
		(
			String.format( "%" + numberOfBits + "s", Integer.toBinaryString( number ) ).replace( ' ', '0' ).getBytes()
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
}