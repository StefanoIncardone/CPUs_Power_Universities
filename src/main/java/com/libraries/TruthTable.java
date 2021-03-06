package com.libraries;

import com.CPU.components.Component;
import com.libraries.utilityClasses.Binary;

public final class TruthTable
{
	private final int numberOfInputs;
	private final int numberOfOutputs;
	private final String[] columnNames;
	private final byte[][] data;
	
	private final StringBuilder truthTable = new StringBuilder();

	public TruthTable( Component component )
	{
		this.numberOfInputs = component.getNumberOfInputs();
		this.numberOfOutputs = component.getNumberOfOutputs();
		this.columnNames = component.getColumnNames();
		this.data = getData( component );

		constructTruthTable();
	}

	@Override
	public String toString()
	{
		return truthTable.toString();
	}

	private byte[][] getData( Component component )
	{
		int numberOfRows = (int) Math.pow( 2, numberOfInputs );
		int numberOfColumns = numberOfInputs + numberOfOutputs;

		byte[][] table = new byte[ numberOfRows ][ numberOfColumns ];
		populateTable( component, table );

		return table;
	}

	private void populateTable( Component component, byte[][] table )
	{
		for( int row = 0; row < table.length; row++ )
		{
			byte[] bits = Binary.toBitsArray( row, numberOfInputs );
			populateRow( component, table, bits, row );
		}
	}

	private void populateRow( Component component, byte[][] table, byte[] input, int row )
	{
		System.arraycopy( input, 0, table[ row ], 0, input.length );
		
		byte[] output = component.out( input );
		for( int counter = input.length; counter < table[ 0 ].length; counter++ )
		{
			table[ row ][ counter ] = output[ counter - input.length ];
		}
	}

	private void constructTruthTable()
	{
		createRow( columnNames );
		String rowSeparator = createRowSeparator( truthTable.toString() );

		truthTable.insert( 0, rowSeparator );
		truthTable.append( rowSeparator );
		
		for( byte[] row : data )
		{
			createRow( toWrapper( row ) );
		}
		
		truthTable.append( rowSeparator );
		truthTable.deleteCharAt( truthTable.length() - 1 );
	}
	
	private void createRow( Object[] values )
	{
		for( int index = 0; index < values.length; index++ )
		{
			truthTable.append( String.format( "| %-" + columnNames[ index ].length() + "s ", values[ index ] ) );
		}
		truthTable.append( "|\n" );
	}
	
	private String createRowSeparator( String row )
	{
		StringBuilder rowSeparator = new StringBuilder();
		
		for( char character : row.toCharArray() )
		{
			rowSeparator.append( (character == '|') ? "+" : "-" );
		}
		rowSeparator.setCharAt( rowSeparator.length() - 1, '\n' );

		return rowSeparator.toString();
	}

	private Byte[] toWrapper( byte[] values )
	{
		Byte[] bytes = new Byte[ values.length ];

		for( int index = 0; index < values.length; index++ )
		{
			bytes[ index ] = values[ index ];
		}

		return bytes;
	}
}