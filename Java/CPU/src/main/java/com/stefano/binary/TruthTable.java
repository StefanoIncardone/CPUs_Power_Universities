package com.stefano.binary;

public class TruthTable
{
	private String[] columnNames;
	private byte[][] data;
	private StringBuilder table = new StringBuilder();

	public TruthTable( String[] columns, byte[][] data )
	{
		this.columnNames = columns;
		this.data = data;

		constructTable();
	}

	@Override
	public String toString()
	{
		return table.toString();
	}

	private String constructTable()
	{
		createColumnNamesRow();

		String rowSeparator = createRowSeparator();
		table.insert( 0, rowSeparator );
		table.append( rowSeparator );
		
		for( byte[] row : data )
		{
			createRow( row );
		}
		
		trimStartAndEndNewLines();
		table.append( rowSeparator );

		return table.toString();
	}

	private void createColumnNamesRow()
	{
		for( String name : columnNames )
		{
			table.append( String.format( "| %-" + name.length() + "s ", name ) );
		}
		table.append( "|" );
	}

	private void createRow( byte[] values )
	{
		for( int index = 0; index < values.length; index++ )
		{
			table.append( String.format( "| %-" + columnNames[ index ].length() + "d ", values[ index ] ) );
		}
		table.append( "|\n" );
	}

	private String createRowSeparator()
	{
		StringBuilder rowSeparator = new StringBuilder();

		rowSeparator.append( "\n" );
		for( char character : table.toString().toCharArray() )
		{
			rowSeparator.append( (character == '|') ? "+" : "-" );
		}
		rowSeparator.append( "\n" );

		return rowSeparator.toString();
	}

	private void trimStartAndEndNewLines()
	{
		table.deleteCharAt( 0 );
		table.deleteCharAt( table.length() - 1 );
	}
}
