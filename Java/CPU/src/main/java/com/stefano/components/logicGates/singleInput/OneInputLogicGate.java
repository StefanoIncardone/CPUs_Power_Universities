package com.stefano.components.logicGates.singleInput;

import com.stefano.binary.Binary;
import com.stefano.components.logicGates.LogicGate;

public abstract class OneInputLogicGate implements LogicGate
{
	protected static final int INPUT_COL = 0;
	protected static final int OUTPUT_COL = 1;

	private static final int NUMBER_OF_INPUTS = 1;
	private static final int TRUTH_TABLE_ROWS = (int) Math.pow( 2, NUMBER_OF_INPUTS );
	private static final int NUMBER_OF_COLUMNS = NUMBER_OF_INPUTS + NUMBER_OF_OUTPUTS;

	@Override
	public String[] getTruthTableColumnNames()
	{
		return new String[]{ "A", this.getClass().getSimpleName() + " A" };
	}

	@Override
	public int[][] getTable()
	{
		return new int[ TRUTH_TABLE_ROWS ][ NUMBER_OF_COLUMNS ];
	}

	@Override
	public void populateTruthTable( int[][] data )
	{
		int row = 0;
		for( int A : Binary.VALUES )
		{
			this.populateTableRow( data, row, new int[]{ A } );
			row++;
		}
	}

	@Override
	public void populateTableRow( int[][] data, int row, int[] input )
	{
		data[ row ][ INPUT_COL ] = input[ INPUT_COL ];
		data[ row ][ OUTPUT_COL ] = this.out( input )[ OUTPUT ];
	}
}
