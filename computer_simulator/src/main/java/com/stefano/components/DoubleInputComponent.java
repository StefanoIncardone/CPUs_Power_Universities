package com.stefano.components;

public interface DoubleInputComponent extends Component
{
	int NUMBER_OF_INPUTS = 2;
	int NUMBER_OF_COLUMNS = NUMBER_OF_INPUTS + 1;
	int TRUTH_TABLE_ROWS = (int) Math.pow( 2, NUMBER_OF_INPUTS );

	int INPUT_A = 0;
	int INPUT_B = 1;
	int OUTPUT = 2;

	public abstract void populateTableRow( int[][] data, int row, int A, int B );
}
