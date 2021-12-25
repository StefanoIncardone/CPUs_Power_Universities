package com.stefano.components;

import com.stefano.binary.Binary;
import com.stefano.binary.TruthTable;

public abstract class Component implements Binary
{
	protected abstract void setComponentAttributes();

	protected abstract void populateTruthTable( byte[][] data );

	protected abstract void populateTableRow( byte[][] data, int row, byte[] input );

	protected abstract byte[] out( byte[] inputs );

	protected int NUMBER_OF_INPUTS;

	protected int NUMBER_OF_OUTPUTS;

	protected String[] COLUMN_NAMES;

	public Component()
	{
		this.setComponentAttributes();
	}

	public int getNumberOfInputs()
	{
		return this.NUMBER_OF_INPUTS;
	}

	public int getNumberOfOutputs()
	{
		return this.NUMBER_OF_OUTPUTS;
	}

	private String[] getTruthTableColumnNames()
	{
		return this.COLUMN_NAMES;
	}

	private byte[][] getTable()
	{
		final int TRUTH_TABLE_ROWS = (int) Math.pow( 2, NUMBER_OF_INPUTS );
		final int NUMBER_OF_COLUMNS = NUMBER_OF_INPUTS + NUMBER_OF_OUTPUTS;

		return new byte[ TRUTH_TABLE_ROWS ][ NUMBER_OF_COLUMNS ];
	}
	
	public String getTruthTable()
	{
		String[] columnNames = this.getTruthTableColumnNames();
		byte[][] table = this.getTable();
		this.populateTruthTable( table );

		TruthTable truthTable = new TruthTable( columnNames, table );
		
		return truthTable.toString();
	}
}
