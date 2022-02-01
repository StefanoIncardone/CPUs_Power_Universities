package com.libraries.utilityClasses;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public final class Utilities extends UtilityClass
{
	// suppress default constructor for non-instantiability
	private Utilities()
	{
		super( Utilities.class );
	}

	public static byte[] convertToBytes( Object object ) throws IOException
	{
		try
		(
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream( bos )
		)
		{
			out.writeObject( object );
			return bos.toByteArray();
		} 
	}

	public static int getObjectSize( Object object ) throws IOException
	{
		return convertToBytes( object ).length;
	}
}
