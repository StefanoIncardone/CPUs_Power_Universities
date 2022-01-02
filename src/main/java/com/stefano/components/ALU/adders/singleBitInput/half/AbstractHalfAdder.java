package com.stefano.components.ALU.adders.singleBitInput.half;

import com.stefano.binary.Binary;
import com.stefano.components.ALU.adders.singleBitInput.Adder;

public abstract class AbstractHalfAdder extends Adder
{
	protected static final int INPUT_COL_A = 0;
	protected static final int INPUT_COL_B = 1;
	protected static final int OUTPUT_COL_CARRY = 2;
	protected static final int OUTPUT_COL_SUM = 3;

	private static final int NUMBER_OF_INPUTS = 2;
	private static final String[] COLUMN_NAMES = new String[]{ "A", "B", "CARRY OUT", "SUM" };

	public AbstractHalfAdder()
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
	protected void populateTableRow(byte[][] data, int row, byte[] input )
	{
		byte[] output = this.out( input );
		
		data[ row ][ INPUT_COL_A ] = input[ INPUT_COL_A ];
		data[ row ][ INPUT_COL_B ] = input[ INPUT_COL_B ];
		data[ row ][ OUTPUT_COL_CARRY ] = output[ CARRY ];
		data[ row ][ OUTPUT_COL_SUM ] = output[ SUM ];
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
