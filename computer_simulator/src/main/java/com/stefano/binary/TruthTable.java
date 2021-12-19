package com.stefano.binary;

import com.stefano.components.Component;

public class TruthTable
{
	public static String create( Component component )
	{
		String[] columns = component.getTruthTableColumnNames();
		int[][] data = component.getTable();
		component.populateTruthTable( data );

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
