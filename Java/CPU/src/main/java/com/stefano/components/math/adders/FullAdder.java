package com.stefano.components.math.adders;

import com.stefano.binary.Binary;
import com.stefano.components.logicGates.LogicGate;
import com.stefano.components.logicGates.doubleInput.OR;

public class FullAdder implements Adder
{
	private static final int CARRY_IN_COL = 0;
	private static final int INPUT_COL_A = 1;
	private static final int INPUT_COL_B = 2;
	private static final int SUM_COL = 3;
	private static final int CARRY_OUT_COL = 4;

	private static final int NUMBER_OF_INPUTS = 3;
	private static final int TRUTH_TABLE_ROWS = (int) Math.pow( 2, NUMBER_OF_INPUTS );
	private static final int NUMBER_OF_COLUMNS = NUMBER_OF_INPUTS + NUMBER_OF_OUTPUTS;

	@Override
	public String[] getTruthTableColumnNames()
	{
		return new String[]{ "C", "A", "B", "SUM", "CARRY" };
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
		for( int C : Binary.VALUES )
		{
			for( int A : Binary.VALUES )
			{
				for( int B : Binary.VALUES )
				{
					this.populateTableRow( data, row, new int[]{ C, A, B } );
					row++;
				}
			}
		}
	}

	@Override
	public void populateTableRow(int[][] data, int row, int[] input )
	{
		int[] output = this.out( input );
		
		data[ row ][ CARRY_IN_COL ] = input[ CARRY_IN_COL ];
		data[ row ][ INPUT_COL_A ] = input[ INPUT_COL_A ];
		data[ row ][ INPUT_COL_B ] = input[ INPUT_COL_B ];
		data[ row ][ SUM_COL ] = output[ SUM ];
		data[ row ][ CARRY_OUT_COL ] = output[ CARRY ];
	}

	private final HalfAdder firstHalfAdder = new HalfAdder();
	private final HalfAdder secondHalfAdder = new HalfAdder();
	private final OR or = new OR();

	@Override
	public int[] out( int[] input )
	{
		final int C = input[ CARRY_IN_COL ];
		final int A = input[ INPUT_COL_A ];
		final int B = input[ INPUT_COL_B ];

		int[] firstOutput = firstHalfAdder.out( new int[]{ A, B } );
		int[] secondOutput = secondHalfAdder.out( new int[] { firstOutput[ SUM ], C } );
		int carriesOutput = or.out( new int[]{ firstOutput[ CARRY ], secondOutput[ CARRY ] } )[ LogicGate.OUTPUT ];
	
		return new int[]{ secondOutput[ SUM ], carriesOutput };
	}
}
