package com.stefano.components.logicGates.doubleInput;

import com.stefano.components.binary.TruthTable;
import com.stefano.components.logicGates.Gate;

public abstract class DoubleInputGate extends Gate
{
	private static final int NUMBER_OF_INPUTS = 2;
	private static final int NUMBER_OF_COLUMNS = NUMBER_OF_INPUTS + 1;

	private static final int INPUT_A = 0;
	private static final int INPUT_B = 1;
	private static final int OUTPUT = 2;

	public static void createTruthTable( Class<? extends DoubleInputGate> gateClass, StringBuilder table )
	{
		String[] columns = { "A", "B", "A " + gateClass.getSimpleName() + " B" };
		int[][] data = new int[ (int) Math.pow( 2, NUMBER_OF_INPUTS ) ][ NUMBER_OF_COLUMNS ];

		int row = 0;
		for( int A = 0; A <= 1; A++ )
		{
			for( int B = 0; B <= 1; B++, row++ )
			{
				data[ row ][ INPUT_A ] = A;
				data[ row ][ INPUT_B ] = B;
				data[ row ][ OUTPUT ] = evaluateResult( gateClass, A, B );
			}
		}

		table.append( TruthTable.create( columns, data ) );
	}
	
	private static int evaluateResult( Class<? extends DoubleInputGate> gateClass, int A, int B )
	{
		try
		{
			return (int) gateClass.getMethods()[ 0 ].invoke( null, A, B );
		}
		catch( Exception exception )
		{
			exception.printStackTrace();
			return -1;
		}
	}
}
