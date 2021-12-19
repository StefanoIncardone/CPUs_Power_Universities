package com.stefano.components.math.adders;

import com.stefano.components.TripleInputComponent;
import com.stefano.components.logicGates.LogicGate;
import com.stefano.components.logicGates.doubleInput.OR;

public class FullAdder implements TripleInputComponent
{
	protected static final int CARRY_IN_COL = 0;
	protected static final int INPUT_COL_A = 1;
	protected static final int INPUT_COL_B = 2;
	protected static final int SUM_COL = 3;
	protected static final int CARRY_OUT_COL = 4;

	private static final int NUMBER_OF_OUTPUTS = 2;
	public static final int NUMBER_OF_COLUMNS = NUMBER_OF_INPUTS + NUMBER_OF_OUTPUTS;

	@Override
	public String[] getTruthTableColumnNames()
	{
		return new String[]{ "C", "A", "B", "SUM", "CARRY" };
	}

	@Override
	public int[][] getTable()
	{
		return new int[ TripleInputComponent.TRUTH_TABLE_ROWS ][ NUMBER_OF_COLUMNS ];
	}

	@Override
	public void populateTruthTable( int[][] data )
	{
		int row = 0;
		for( int C : new int[]{ 0, 1 } )
		{
			for( int A : new int[]{ 0 , 1 } )
			{
				for( int B : new int[]{ 0 , 1 } )
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
		data[ row ][ SUM_COL ] = output[ HalfAdder.SUM ];
		data[ row ][ CARRY_OUT_COL ] = output[ HalfAdder.CARRY ];
	}

	private final HalfAdder firstHalfAdder = new HalfAdder();
	private final HalfAdder secondHalfAdder = new HalfAdder();
	private final OR or = new OR();

        @Override
	public int[] out( int[] input )
	{
		int[] firstResult = firstHalfAdder.out( new int[]{ input[ INPUT_COL_A ], input[ INPUT_COL_B ] } );
		int[] secondResult = secondHalfAdder.out( new int[] { firstResult[ HalfAdder.SUM ], input[ CARRY_IN_COL ] } );
		int[] orInput = new int[]{ firstResult[ HalfAdder.CARRY ], secondResult[ HalfAdder.CARRY ] };
	
		return new int[]{ secondResult[ HalfAdder.SUM ], or.out( orInput )[ LogicGate.OUTPUT ] };
	}
}
