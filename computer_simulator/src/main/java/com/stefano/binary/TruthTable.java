package com.stefano.binary;

public class TruthTable
{
	public static String create( String[] columns, int[][] data )
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
