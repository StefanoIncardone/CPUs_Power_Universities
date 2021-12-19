package com.stefano.components.logicGates.singleInput;

import com.stefano.components.SingleInputComponent;

public abstract class SingleInputLogicGate implements SingleInputComponent
{
	@Override
	public String[] getTruthTableColumnNames()
	{
		return new String[]{ "A", this.getClass().getSimpleName() + " A" };
	}

	@Override
	public int[][] getTable()
	{
		return new int[ SingleInputComponent.TRUTH_TABLE_ROWS ][ SingleInputComponent.NUMBER_OF_COLUMNS ];
	}

	@Override
	public void populateTruthTable( int[][] data )
	{
		int row = 0;
		for( int A : new int[]{ 0, 1 } )
		{
			this.populateTableRow( data, row, A );
			row++;
		}
	}

	@Override
	public void populateTableRow( int[][] data, int row, int A )
	{
		data[ row ][ SingleInputComponent.INPUT ] = A;
		data[ row ][ SingleInputComponent.OUTPUT ] = this.out( A );
	}

	public abstract int out( int A );
}
