package com.libraries.exceptions;

import com.CPU.components.Component;

public final class InputAmountException extends ComponentInputException
{
	public InputAmountException( int numberOfInputBits, Component component )
	{
		super
		(
			"number of input bits (%d) does not match the component's (%s) requirements (%d)"
				.formatted( numberOfInputBits, component.getClass().getCanonicalName(), component.getNumberOfInputs() )
		);
	}
}
