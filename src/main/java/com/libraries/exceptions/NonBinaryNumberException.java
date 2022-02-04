package com.libraries.exceptions;

public final class NonBinaryNumberException extends ComponentInputException
{
	public NonBinaryNumberException()
	{
		super( "input contains non-binary numbers (0/1)" );
	}
}
