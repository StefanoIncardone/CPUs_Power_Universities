package com.stefano.components.logicGates.singleInput;

import com.stefano.binary.TruthTable;
import com.stefano.components.logicGates.Gate;

public abstract class SingleInputGate extends Gate
{
	private static final int NUMBER_OF_INPUTS = 1;
	private static final int NUMBER_OF_COLUMNS = NUMBER_OF_INPUTS + 1;

	private static final int INPUT = 0;
	private static final int OUTPUT = 1;

	public static void createTruthTable( Class<? extends SingleInputGate> gateClass, StringBuilder table )
	{
		String[] columns = { "A", gateClass.getSimpleName() + " A" };
		int[][] data = new int[ (int) Math.pow( 2, NUMBER_OF_INPUTS ) ][ NUMBER_OF_COLUMNS ];
		
		for( int A = 0, row = 0; A <= 1; A++, row++ )
		{
			data[ row ][ INPUT ] = A;
			data[ row ][ OUTPUT ] = evaluateResult( gateClass, A );
		}

		table.append( TruthTable.create( columns, data ) );
	}
	
	private static int evaluateResult( Class<? extends SingleInputGate> gateClass, int A )
	{
		try
		{
			return (int) gateClass.getMethods()[ 0 ].invoke( null, A );
		}
		catch( Exception exception )
		{
			exception.printStackTrace();
			return -1;
		}
	}
}
