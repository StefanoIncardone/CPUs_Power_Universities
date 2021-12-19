package com.stefano.binary;

import com.stefano.components.logicGates.singleInput.SingleInputLogicGate;
import com.stefano.components.logicGates.doubleInput.DoubleInputLogicGate;
import com.stefano.components.math.adders.HalfAdder;

public class TruthTable
{
	public static String create( SingleInputLogicGate gate )
	{
		String[] columns = gate.getTruthTableColumnNames();
		int[][] data = gate.getTable();
		
		int row = 0;
		for( int A : new int[]{ 0, 1 } )
		{
			gate.populateTableRow( data, row, A );
			row++;
		}

		return elaborateData( columns, data );
	}

	public static String create( DoubleInputLogicGate gate )
	{
		String[] columns = gate.getTruthTableColumnNames();
		int[][] data = gate.getTable();

		int row = 0;
		for( int A : new int[]{ 0, 1 } )
		{
			for( int B : new int[]{ 0 , 1 } )
			{
				gate.populateTableRow( data, row, A, B );
				row++;
			}
		}

		return elaborateData( columns, data );
	}

	public static String create( HalfAdder halfAdder )
	{
		String[] columns = halfAdder.getTruthTableColumnNames();
		int[][] data = halfAdder.getTable();

		int row = 0;
		for( int A : new int[]{ 0, 1 } )
		{
			for( int B : new int[]{ 0 , 1 } )
			{
				halfAdder.populateTableRow( data, row, A, B );
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

		for( char character : table.toString().toCharArray() )
		{
			table.append( (character == '|') ? "+" : "-" );
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
