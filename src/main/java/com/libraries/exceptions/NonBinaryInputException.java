package com.libraries.exceptions;

public final class NonBinaryInputException extends ComponentInputException
{
	public NonBinaryInputException()
	{
		super( "input contains non-binary numbers (0/1)" );
	}
}
