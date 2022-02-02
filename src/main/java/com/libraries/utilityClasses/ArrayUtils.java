package com.libraries.utilityClasses;

public final class ArrayUtils extends UtilityClass
{
	// suppress default constructor for non-instantiability
	private ArrayUtils()
	{
		super( ArrayUtils.class );
	}

	public static Byte[] toWrapper( byte[] values )
	{
		Byte[] bytes = new Byte[ values.length ];

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

	// public static byte[] toByteArray( Object object ) throws IOException
	// {
	// 	try
	// 	(
	// 		ByteArrayOutputStream bos = new ByteArrayOutputStream();
	// 		ObjectOutputStream out = new ObjectOutputStream( bos );
	// 	)
	// 	{
	// 		out.writeObject( object );
	// 		return bos.toByteArray();
	// 	} 
	// }

	// public static int getObjectSize( Object object ) throws IOException
	// {
	// 	return toByteArray( object ).length;
	// }
}
