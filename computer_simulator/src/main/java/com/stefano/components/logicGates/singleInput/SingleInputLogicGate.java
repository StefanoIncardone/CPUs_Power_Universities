package com.stefano.components.logicGates.singleInput;

import com.stefano.components.SingleInputComponent;
import com.stefano.components.logicGates.LogicGate;

public abstract class SingleInputLogicGate implements LogicGate, SingleInputComponent
{
	protected static final int INPUT_COL = 0;
	protected static final int OUTPUT_COL = 1;

	private static final int NUMBER_OF_OUTPUTS = 1;
	public static final int NUMBER_OF_COLUMNS = NUMBER_OF_INPUTS + NUMBER_OF_OUTPUTS;

	@Override
	public String[] getTruthTableColumnNames()
	{
		return new String[]{ "A", this.getClass().getSimpleName() + " A" };
	}

	@Override
	public int[][] getTable()
	{
		return new int[ SingleInputComponent.TRUTH_TABLE_ROWS ][ NUMBER_OF_COLUMNS ];
	}

	@Override
	public void populateTruthTable( int[][] data )
	{
		int row = 0;
		for( int A : new int[]{ 0, 1 } )
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
