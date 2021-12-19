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
	public void populateTruthTable( int[][] data )
	{
		int row = 0;
		for( int A : new int[]{ 0, 1 } )
		{
			for( int B : new int[]{ 0 , 1 } )
			{
				this.populateTruthTableRow( data, row, A, B );
				row++;
			}
		}
	}

	@Override
	public void populateTruthTableRow( int[][] data, int row, int A, int B )
	{
		data[ row ][ DoubleInputComponent.INPUT_A ] = A;
		data[ row ][ DoubleInputComponent.INPUT_B ] = B;
		data[ row ][ DoubleInputComponent.OUTPUT ] = this.out( A, B );
	}

	public abstract int out( int A, int B );
}
