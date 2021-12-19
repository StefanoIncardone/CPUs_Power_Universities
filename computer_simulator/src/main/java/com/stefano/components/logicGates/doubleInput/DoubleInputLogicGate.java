package com.stefano.components.logicGates.doubleInput;

import com.stefano.components.DoubleInputComponent;
import com.stefano.components.logicGates.LogicGate;

public abstract class DoubleInputLogicGate implements LogicGate, DoubleInputComponent
{
	protected static final int INPUT_COL_A = 0;
	protected static final int INPUT_COL_B = 1;
	protected static final int OUTPUT_COL = 2;

	private static final int NUMBER_OF_OUTPUTS = 1;
	public static final int NUMBER_OF_COLUMNS = NUMBER_OF_INPUTS + NUMBER_OF_OUTPUTS;

	@Override
	public String[] getTruthTableColumnNames()
	{
		return new String[]{ "A", "B", "A " + this.getClass().getSimpleName() + " B" };
	}
	
	@Override
	public int[][] getTable()
	{
		return new int[ DoubleInputComponent.TRUTH_TABLE_ROWS ][ NUMBER_OF_COLUMNS ];
	}

	@Override
	public void populateTruthTable( int[][] data )
	{
		int row = 0;
		for( int A : new int[]{ 0, 1 } )
		{
			for( int B : new int[]{ 0 , 1 } )
			{
				this.populateTableRow( data, row, new int[]{ A, B } );
				row++;
			}
		}
	}

	@Override
	public void populateTableRow( int[][] data, int row, int[] input )
	{
		data[ row ][ INPUT_COL_A ] = input[ INPUT_COL_A ];
		data[ row ][ INPUT_COL_B ] = input[ INPUT_COL_B ];
		data[ row ][ OUTPUT_COL ] = this.out( input )[ OUTPUT ];
	}
}
