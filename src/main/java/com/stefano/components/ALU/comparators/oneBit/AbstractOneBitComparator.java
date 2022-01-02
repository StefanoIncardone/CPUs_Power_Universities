package com.stefano.components.ALU.comparators.oneBit;

import com.stefano.binary.Binary;
import com.stefano.components.ALU.comparators.Comparator;

public abstract class AbstractOneBitComparator extends Comparator
{
	protected static final int INPUT_COL_A = 0;
	protected static final int INPUT_COL_B = 1;
	protected static final int OUTPUT_COL_LESS = 2;
	protected static final int OUTPUT_COL_LESS_OR_EQUAL = 3;
	protected static final int OUTPUT_COL_EQUAL = 4;
	protected static final int OUTPUT_COL_GREATER_OR_EQUAL = 5;
	protected static final int OUTPUT_COL_GREATER = 6;

	private static final int NUMBER_OF_INPUTS = 2;
	private static final String[] COLUMN_NAMES = new String[]
	{
		"A",
		"B",
		"LESS",
		"LESS OR EQUAL",
		"EQUAL",
		"GREATER OR EQUAL",
		"GREATER"
	};

	public AbstractOneBitComparator()
	{
		super.setNumberOfInputs( NUMBER_OF_INPUTS );
		super.setNumberOfOutputs( NUMBER_OF_OUTPUTS );
		super.setColumnNames( COLUMN_NAMES );
	}

	@Override
	protected void populateTruthTable( byte[][] data )
	{
		int row = 0;
		for( byte A : Binary.VALUES )
		{
			for( byte B : Binary.VALUES )
			{
				this.populateTableRow( data, row, new byte[]{ A, B } );
				row++;
			}
		}
	}

	@Override
	protected void populateTableRow( byte[][] data, int row, byte[] input )
	{
		byte[] output = this.out( input );

		data[ row ][ INPUT_COL_A ] = input[ INPUT_COL_A ];
		data[ row ][ INPUT_COL_B ] = input[ INPUT_COL_B ];
		data[ row ][ OUTPUT_COL_LESS ] = output[ LESS ];
		data[ row ][ OUTPUT_COL_LESS_OR_EQUAL ] = output[ LESS_OR_EQUAL ];
		data[ row ][ OUTPUT_COL_EQUAL ] = output[ EQUAL ];
		data[ row ][ OUTPUT_COL_GREATER_OR_EQUAL ] = output[ GREATER_OR_EQUAL ];
		data[ row ][ OUTPUT_COL_GREATER ] = output[ GREATER ];
	}

	public byte[] out( byte A, byte B )
	{
		return this.out( new byte[]{ A, B } );
	}

	public byte[] out( int A, int B )
	{
		return this.out( (byte) A, (byte) B );
	}
}
