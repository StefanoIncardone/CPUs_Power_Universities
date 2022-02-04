package com.libraries.utilityClasses;

// TODO get rid of utility classes
public abstract sealed class UtilityClass permits Binary
{
	protected UtilityClass( Class<? extends UtilityClass> utilityClass )
	{
		throw new InstantiationError
		(
			"%s class cannot be instantiated, as it is an utility class".formatted( utilityClass )
		);
	}
}
