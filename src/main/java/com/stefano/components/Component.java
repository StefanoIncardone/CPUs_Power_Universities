package com.stefano.components;

import com.stefano.binary.Binary;
import com.stefano.binary.TruthTable;

public abstract class Component implements Binary
{
	private int NUMBER_OF_INPUTS;

	private int NUMBER_OF_OUTPUTS;

	private String[] COLUMN_NAMES;

	protected abstract void populateTruthTable( byte[][] data );

	protected abstract void populateTableRow( byte[][] data, int row, byte[] input );

	protected abstract byte[] out( byte[] inputs );
	
	public String getTruthTable()
	{
		int NUMBER_OF_ROWS = (int) Math.pow( 2, NUMBER_OF_INPUTS );
		int NUMBER_OF_COLUMNS = NUMBER_OF_INPUTS + NUMBER_OF_OUTPUTS;

		byte[][] table = new byte[ NUMBER_OF_ROWS ][ NUMBER_OF_COLUMNS ];
		populateTruthTable( table );

		return new TruthTable( COLUMN_NAMES, table ).toString();
	}

	protected void setNumberOfInputs( int amount )
	{
		NUMBER_OF_INPUTS = amount;
	}

	protected void setNumberOfOutputs( int amount )
	{
		NUMBER_OF_OUTPUTS = amount;
	}

	protected void setColumnNames( String[] names )
	{
		COLUMN_NAMES = names;
	}

	public int getNumberOfInputs()
	{
		return NUMBER_OF_INPUTS;
	}

	public int getNumberOfOutputs()
	{
		return NUMBER_OF_OUTPUTS;
	}
}
