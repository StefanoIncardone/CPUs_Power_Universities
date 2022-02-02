package com.libraries.exceptions;

public class NonBinaryInputException extends IllegalArgumentException
{
	private static final String MESSAGE = "input contains non-binary values";

	public NonBinaryInputException()
	{
		super( MESSAGE );
	}
}
