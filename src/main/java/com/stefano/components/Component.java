package com.stefano.components;

import com.stefano.binary.Binary;

public abstract class Component
{
	public final int NUMBER_OF_INPUTS;

	public final int NUMBER_OF_OUTPUTS;

	private final String[] COLUMN_NAMES;

	private String TRUTH_TABLE = null;

	protected abstract int getNumberOfInputs();

	protected abstract int getNumberOfOutputs();

	protected abstract String[] getColumnNames();

	protected abstract byte[] out( byte[] inputs );

	public Component()
	{
		NUMBER_OF_INPUTS = getNumberOfInputs();
		NUMBER_OF_OUTPUTS = getNumberOfOutputs();
		COLUMN_NAMES = getColumnNames();
	}

	public String getTruthTable()
	{
		if( TRUTH_TABLE == null )
		{
			constructTable();
		}

		return TRUTH_TABLE;
	}

	private void constructTable()
	{
		byte[][] table = getTable();
		getTableValues( table );

		TRUTH_TABLE = new TruthTable( COLUMN_NAMES, table ).toString();
	}

	private byte[][] getTable()
	{
		int numberOfRows = (int) Math.pow( 2, NUMBER_OF_INPUTS );
		int numberOfColumns = NUMBER_OF_INPUTS + NUMBER_OF_OUTPUTS;

		return new byte[ numberOfRows ][ numberOfColumns ];
	}

	private void getTableValues( byte[][] table )
	{
		for( int row = 0; row < table.length; row++ )
		{
			byte[] bits = Binary.toBitArray( row, NUMBER_OF_INPUTS );
			populateRow( table, bits, row );
		}
	}

	private void populateRow( byte[][] table, byte[] input, int row )
	{
		for( int counter = 0; counter < input.length; counter++ )
		{
			table[ row ][ counter ] = input[ counter ];
		}
		
		byte[] output = this.out( input );

		for( int counter = input.length; counter < table[ 0 ].length; counter++ )
		{
			table[ row ][ counter ] = output[ counter - input.length ];
		}
	}
}
