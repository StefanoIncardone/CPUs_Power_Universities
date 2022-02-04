package com.libraries.exceptions;

public abstract sealed class ComponentInputException extends IllegalArgumentException
	permits InputAmountException, NonBinaryInputException
{
	private final String MESSAGE;

	protected ComponentInputException( String message )
	{
		MESSAGE = message;
	}

	@Override
	public String getMessage()
	{
		return MESSAGE;
	}
}
