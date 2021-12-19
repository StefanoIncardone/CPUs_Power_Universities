package com.stefano.components.math.adders;

import com.stefano.binary.Binary;
import com.stefano.components.logicGates.LogicGate;
import com.stefano.components.logicGates.doubleInput.AND;
import com.stefano.components.logicGates.doubleInput.XOR;

public class HalfAdder implements Adder
{
	protected static final int INPUT_COL_A = 0;
	protected static final int INPUT_COL_B = 1;
	protected static final int SUM_COL = 2;
	protected static final int CARRY_COL = 3;

	private static final int NUMBER_OF_INPUTS = 2;
	private static final int TRUTH_TABLE_ROWS = (int) Math.pow( 2, NUMBER_OF_INPUTS );
	private static final int NUMBER_OF_COLUMNS = NUMBER_OF_INPUTS + NUMBER_OF_OUTPUTS;

	@Override
	public String[] getTruthTableColumnNames()
	{
		return new String[]{ "A", "B", "SUM", "CARRY" };
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
			for( int B : Binary.VALUES )
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
