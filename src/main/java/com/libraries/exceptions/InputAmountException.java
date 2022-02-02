package com.libraries.exceptions;

import com.CPU.components.Component;

public class InputAmountException extends IllegalArgumentException
{
	private static final String MESSAGE =
		"number of input bits (%d) does not match the component's (%s) requirements (%d)";

	public InputAmountException( int numberOfInputBits, Component gate )
	{
		super( MESSAGE.formatted( numberOfInputBits, gate.getClass().getCanonicalName(), gate.getNumberOfInputs() ) );
	}
}
