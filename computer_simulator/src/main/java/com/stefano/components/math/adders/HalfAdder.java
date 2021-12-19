package com.stefano.components.math.adders;

import com.stefano.components.DoubleInputComponent;
import com.stefano.components.logicGates.doubleInput.AND;
import com.stefano.components.logicGates.doubleInput.XOR;

public class HalfAdder implements DoubleInputComponent
{
	public static final int NUMBER_OF_OUTPUTS = 2;
	public static final int NUMBER_OF_COLUMNS = DoubleInputComponent.NUMBER_OF_INPUTS + NUMBER_OF_OUTPUTS;
	public static final int TRUTH_TABLE_ROWS = (int) Math.pow( 2, DoubleInputComponent.NUMBER_OF_INPUTS );

	public static final int OUTPUT = 0;
	public static final int CARRY = 1;
	public static final int CARRY_OUTPUT = DoubleInputComponent.OUTPUT + 1;
	
	private final XOR xor = new XOR();
	private final AND and = new AND();

	public int[] out( int A, int B )
	{
		return new int[]{ xor.out( A, B ), and.out( A, B ) };
	}

	@Override
	public String[] getTruthTableColumnNames()
	{
		return new String[]{ "A", "B", "OUTPUT", "CARRY" };
	}

	@Override
	public int[][] getTable()
	{
		return new int[ DoubleInputComponent.TRUTH_TABLE_ROWS ][ NUMBER_OF_COLUMNS ];
	}

	@Override
	public void populateTableRow(int[][] data, int row, int A, int B)
	{
		data[ row ][ DoubleInputComponent.INPUT_A ] = A;
		data[ row ][ DoubleInputComponent.INPUT_B ] = B;
		data[ row ][ DoubleInputComponent.OUTPUT ] = this.out( A, B )[ OUTPUT ];
		data[ row ][ CARRY_OUTPUT ] = this.out( A, B )[ CARRY ];
	}
}
