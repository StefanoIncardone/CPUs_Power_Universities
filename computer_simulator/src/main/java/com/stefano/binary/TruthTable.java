package com.stefano.binary;

import com.stefano.components.Component;

public class TruthTable
{
	public static String create( Component component )
	{
		String[] columns = component.getTruthTableColumnNames();
		int[][] data = component.getTable();
		component.populateTruthTable( data );

		return costructTable( columns, data );
	}

	private static String costructTable( String[] columns, int[][] data )
	{
		StringBuilder table = new StringBuilder();
		
		for( String column : columns )
		{
			table.append( String.format( "| %-" + column.length() + "s ", column ) );
		}
		table.append( "|" );
		
		String rowSeparator = createRowSeparator( table );
		table.insert( 0, rowSeparator );
		table.append( rowSeparator );
		
		for( int[] row : data )
		{
			for( int index = 0; index < row.length; index++ )
			{
				table.append( String.format( "| %-" + columns[ index ].length() + "d ", row[ index ] ) );
			}
			table.append( "|\n" );
		}
		table.deleteCharAt( table.length() - 1 );
		table.append( rowSeparator );

		adjustFirstRowSeparator( table );
		adjustLastRowSeparator( table );

		return table.toString();
	}

	private static String createRowSeparator( StringBuilder table )
	{
		StringBuilder rowSeparator = new StringBuilder();

		rowSeparator.append( "\n" );
		for( char character : table.toString().toCharArray() )
		{
			rowSeparator.append( (character == '|') ? "+" : "-" );
		}
		rowSeparator.setCharAt( rowSeparator.indexOf( "+" ), '|' );
		rowSeparator.setCharAt( rowSeparator.lastIndexOf( "+" ), '|' );
		rowSeparator.append( "\n" );

		return rowSeparator.toString();
	}

	private static void adjustFirstRowSeparator( StringBuilder table )
	{
		table.setCharAt( table.indexOf( "|" ), '+' );
		table.setCharAt( table.indexOf( "|" ), '+' );
	}

	private static void adjustLastRowSeparator( StringBuilder table )
	{
		table.setCharAt( table.lastIndexOf( "|" ), '+' );
		table.setCharAt( table.lastIndexOf( "|" ), '+' );
	}
}
