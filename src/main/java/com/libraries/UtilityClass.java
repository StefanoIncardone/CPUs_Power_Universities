package com.libraries;

public abstract sealed class UtilityClass permits Binary, Utilities, ArrayUtils
{
	protected UtilityClass( Class<?> utilityClass )
	{
		throw new InstantiationError
		(
			"%s class cannot be instantiated, as it is a sub-class of %s".formatted( utilityClass, UtilityClass.class )
		);
	}
}
