package com.libraries.utilityClasses;

public abstract sealed class UtilityClass permits Binary, Utilities, ArrayUtils
{
	protected UtilityClass( Class<? extends UtilityClass> utilityClass )
	{
		throw new InstantiationError
		(
			"%s class cannot be instantiated, as it is an utility class".formatted( utilityClass )
		);
	}
}
