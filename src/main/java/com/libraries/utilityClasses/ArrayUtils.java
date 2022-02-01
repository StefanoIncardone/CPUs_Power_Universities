package com.libraries.utilityClasses;

public final class ArrayUtils extends UtilityClass
{
	// suppress default constructor for non-instantiability
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

	public static String toStringConcat( byte[] bits )
	{
		StringBuilder value = new StringBuilder();
		for( byte bit : bits )
		{
			value.append( bit );
		}

		return value.toString();
	}
}
