package com.stefano.binary;

public abstract class Binary
{
	private static final int ASCI_NUMBER_OFFSET = 48;

	public static byte[] toBitArray( int number, int padding )
	{
		return applyOffset
		(
			String.format( "%" + padding + "s", Integer.toBinaryString( number ) ).replaceAll( " ", "0" ).getBytes()
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
