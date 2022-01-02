package com.stefano.binary;

public class TruthTable
{
	private final String[] COLUMN_NAMES;
	private final byte[][] DATA;
	private final StringBuilder TABLE = new StringBuilder();

	public TruthTable( String[] names, byte[][] values )
	{
		this.COLUMN_NAMES = names;
		this.DATA = values;

		constructTable();
	}

	@Override
	public String toString()
	{
		return TABLE.toString();
	}

	private void constructTable()
	{
		createColumnNamesRow();

		String rowSeparator = createRowSeparator();
		TABLE.insert( 0, rowSeparator );
		TABLE.append( rowSeparator );
		
		for( byte[] row : DATA )
		{
			createRow( row );
		}
		
		TABLE.append( rowSeparator );
	}
	
	private void createColumnNamesRow()
	{
		for( String name : COLUMN_NAMES )
		{
			TABLE.append( String.format( "| %-" + name.length() + "s ", name ) );
		}
		TABLE.append( "|\n" );
	}
	
	private void createRow( byte[] values )
	{
		for( int index = 0; index < values.length; index++ )
		{
			TABLE.append( String.format( "| %-" + COLUMN_NAMES[ index ].length() + "d ", values[ index ] ) );
		}
		TABLE.append( "|\n" );
	}
	
	private String createRowSeparator()
	{
		StringBuilder rowSeparator = new StringBuilder();
		
		for( char character : TABLE.toString().toCharArray() )
		{
			rowSeparator.append( (character == '|') ? "+" : "-" );
		}
		rowSeparator.setCharAt( rowSeparator.length() - 1, '\n' );

		return rowSeparator.toString();
	}
}
