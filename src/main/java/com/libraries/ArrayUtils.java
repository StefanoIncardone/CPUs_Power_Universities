package com.libraries;

public final class ArrayUtils extends UtilityClass
{
	private ArrayUtils()
	{
		super( ArrayUtils.class );
	}

	public static Byte[] toObject( byte[] values )
	{
		Byte[] bytes = new Byte[ values.length ];

		for( int index = 0; index < values.length; index++ )
		{
			bytes[ index ] = values[ index ];
		}

		return bytes;
	}

	public static Integer[] toObject( int[] values )
	{
		Integer[] bytes = new Integer[ values.length ];

		for( int index = 0; index < values.length; index++ )
		{
			bytes[ index ] = values[ index ];
		}

		return bytes;
	}
}
