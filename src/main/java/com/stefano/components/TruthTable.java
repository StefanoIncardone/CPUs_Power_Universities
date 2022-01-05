package com.stefano.components;

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
		createRow( COLUMN_NAMES );
		String rowSeparator = createRowSeparator();

		TABLE.insert( 0, rowSeparator );
		TABLE.append( rowSeparator );
		
		for( byte[] row : DATA )
		{
			createRow( toObject( row ) );
		}
		
		TABLE.append( rowSeparator );
		TABLE.deleteCharAt( TABLE.length() - 1 );
	}
	
	private void createRow( Object[] values )
	{
		for( int index = 0; index < values.length; index++ )
		{
			TABLE.append( String.format( "| %-" + COLUMN_NAMES[ index ].length() + "s ", values[ index ] ) );
		}
		TABLE.append( "|\n" );
	}
	
	private Byte[] toObject( byte[] values )
	{
		Byte[] bytes = new Byte[ values.length ];

		for( int index = 0; index < values.length; index++ )
		{
			bytes[ index ] = Byte.valueOf( values[ index ] );
		}

		return bytes;
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