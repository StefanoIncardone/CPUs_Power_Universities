package com.stefano.components.logicGates.doubleInput;

import com.stefano.components.DoubleInputComponent;

public abstract class DoubleInputLogicGate implements DoubleInputComponent
{
	@Override
	public String[] getTruthTableColumnNames()
	{
		return new String[]{ "A", "B", "A " + this.getClass().getSimpleName() + " B" };
	}
	
	@Override
	public int[][] getTable()
	{
		return new int[ DoubleInputComponent.TRUTH_TABLE_ROWS ][ DoubleInputComponent.NUMBER_OF_COLUMNS ];
	}

	@Override
	public void populateTableRow( int[][] data, int row, int A, int B )
	{
		data[ row ][ DoubleInputComponent.INPUT_A ] = A;
		data[ row ][ DoubleInputComponent.INPUT_B ] = B;
		data[ row ][ DoubleInputComponent.OUTPUT ] = this.out( A, B );
	}

	public abstract int out( int A, int B );
}
