package com.stefano.components.math.adders;

import com.stefano.components.DoubleInputComponent;
import com.stefano.components.logicGates.LogicGate;
import com.stefano.components.logicGates.doubleInput.AND;
import com.stefano.components.logicGates.doubleInput.XOR;

public class HalfAdder implements DoubleInputComponent
{
	protected static final int INPUT_COL_A = 0;
	protected static final int INPUT_COL_B = 1;
	protected static final int SUM_COL = 2;
	protected static final int CARRY_COL = 3;

	public static final int SUM = 0;
	public static final int CARRY = 1;

	private static final int NUMBER_OF_OUTPUTS = 2;
	public static final int NUMBER_OF_COLUMNS = NUMBER_OF_INPUTS + NUMBER_OF_OUTPUTS;

	@Override
	public String[] getTruthTableColumnNames()
	{
		return new String[]{ "A", "B", "SUM", "CARRY" };
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
	public void populateTableRow(int[][] data, int row, int[] input )
	{
		int[] output = this.out( input );
		
		data[ row ][ INPUT_COL_A ] = input[ INPUT_COL_A ];
		data[ row ][ INPUT_COL_B ] = input[ INPUT_COL_B ];
		data[ row ][ SUM_COL ] = output[ SUM ];
		data[ row ][ CARRY_COL ] = output[ CARRY ];
	}

	private final XOR xor = new XOR();
	private final AND and = new AND();

	@Override
	public int[] out( int[] input )
	{
		return new int[]{ xor.out( input )[ LogicGate.OUTPUT ], and.out( input )[ LogicGate.OUTPUT ] };
	}
}
