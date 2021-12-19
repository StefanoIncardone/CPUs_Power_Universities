package com.stefano.binary;

import com.stefano.components.logicGates.doubleInput.DoubleInputGate;
import com.stefano.components.logicGates.singleInput.SingleInputGate;

public class TruthTable
{
	public static String create( SingleInputGate gate )
	{
		final int NUMBER_OF_INPUTS = 1;
		final int NUMBER_OF_COLUMNS = NUMBER_OF_INPUTS + 1;
		final int INPUT = 0;
		final int OUTPUT = 1;

		String[] columns = { "A", gate.getClass().getSimpleName() + " A" };
		int[][] data = new int[ (int) Math.pow( 2, NUMBER_OF_INPUTS ) ][ NUMBER_OF_COLUMNS ];
		
		int row = 0;
		for( int A : new int[]{ 0, 1 } )
		{
			data[ row ][ INPUT ] = A;
			data[ row ][ OUTPUT ] = gate.out( A );
			
			row++;
		}

		return elaborateData( columns, data );
	}

	public static String create( DoubleInputGate gate )
	{
		final int NUMBER_OF_INPUTS = 2;
		final int NUMBER_OF_COLUMNS = NUMBER_OF_INPUTS + 1;
		final int INPUT_A = 0;
		final int INPUT_B = 1;
		final int OUTPUT = 2;

		String[] columns = { "A", "B", "A " + gate.getClass().getSimpleName() + " B" };
		int[][] data = new int[ (int) Math.pow( 2, NUMBER_OF_INPUTS ) ][ NUMBER_OF_COLUMNS ];

		int row = 0;
		for( int A : new int[]{ 0, 1 } )
		{
			for( int B : new int[]{ 0 , 1 } )
			{
				data[ row ][ INPUT_A ] = A;
				data[ row ][ INPUT_B ] = B;
				data[ row ][ OUTPUT ] = gate.out( A, B );

				row++;
			}
		}

		return elaborateData( columns, data );
	}

	private static String elaborateData( String[] columns, int[][] data )
	{
		StringBuilder table = new StringBuilder();

		for( String column : columns )
		{
			table.append( String.format( "| %s ", column ) );
		}
		table.append( "\n" );

		for( int index = 0, tableLength = table.length(); index < tableLength; index++ )
		{
			table.append( (table.toString().toCharArray()[ index ] == '|') ? "+" : "-" );
		}
		table.append( "\n" );

		for( int[] row : data )
		{
			for( int value : row )
			{
				table.append( String.format( "| %d ", value ) );
			}
			table.append( "\n" );
		}

		return table.toString();
	}
}
