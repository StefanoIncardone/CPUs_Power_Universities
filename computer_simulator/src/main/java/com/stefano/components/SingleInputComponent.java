package com.stefano.components;

public interface SingleInputComponent extends Component
{

	int INPUT = 0;
	int OUTPUT = 1;

	int NUMBER_OF_INPUTS = 1;
	int NUMBER_OF_COLUMNS = NUMBER_OF_INPUTS + 1;
	int TRUTH_TABLE_ROWS = (int) Math.pow( 2, NUMBER_OF_INPUTS );

	public abstract void populateTableRow( int[][] data, int row, int A );
}
