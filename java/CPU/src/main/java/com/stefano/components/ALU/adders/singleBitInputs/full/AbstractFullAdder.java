package com.stefano.components.ALU.adders.singleBitInputs.full;

import com.stefano.binary.Binary;
import com.stefano.components.ALU.adders.singleBitInputs.Adder;

public abstract class AbstractFullAdder extends Adder
{
	protected static final int IMPUT_COL_CARRY = 0;
	protected static final int INPUT_COL_A = 1;
	protected static final int INPUT_COL_B = 2;
	protected static final int OUTPUT_COL_CARRY = 3;
	protected static final int OUTPUT_COL_SUM = 4;

	@Override
	protected void setComponentAttributes()
	{
		super.NUMBER_OF_INPUTS = 3;

		super.COLUMN_NAMES = new String[]{ "CARRY IN", "A", "B", "CARRY OUT", "SUM" };
	}

	@Override
	protected void populateTruthTable( byte[][] data )
	{
		int row = 0;
		for( byte C : Binary.VALUES )
		{
			for( byte A : Binary.VALUES )
			{
				for( byte B : Binary.VALUES )
				{
					this.populateTableRow( data, row, new byte[]{ C, A, B } );
					row++;
				}
			}
		}
	}

	@Override
	protected void populateTableRow( byte[][] data, int row, byte[] input )
	{
		byte[] output = this.out( input );
		
		data[ row ][ IMPUT_COL_CARRY ] = input[ IMPUT_COL_CARRY ];
		data[ row ][ INPUT_COL_A ] = input[ INPUT_COL_A ];
		data[ row ][ INPUT_COL_B ] = input[ INPUT_COL_B ];
		data[ row ][ OUTPUT_COL_CARRY ] = output[ CARRY ];
		data[ row ][ OUTPUT_COL_SUM ] = output[ SUM ];
	}

	public byte[] out( byte C, byte A, byte B )
	{
		return this.out( new byte[]{ C, A, B } );
	}

	public byte[] out( int C, int A, int B )
	{
		return this.out( (byte) C, (byte) A, (byte) B );
	}
}
