package com.stefano.components.logicGates;

import com.stefano.components.Component;

public abstract class Gate extends Component
{
	public static String truthTable( Class<? extends Gate> gateClass )
	{
		StringBuilder table = new StringBuilder
		(
			"\nthe truth table for the " + gateClass.getSimpleName() + " gate is:\n\n"
		);

		try
		{
			gateClass.getSuperclass().getMethods()[ 0 ].invoke( null, gateClass, table );
		}
		catch( Exception exception )
		{
			exception.printStackTrace();
		}

		return table.toString();
	}
}
