package com.stefano.components.ALU.adders.multipleBitsInput.rippleCarry.twoBits;

import com.stefano.binary.Binary;
import com.stefano.components.ALU.adders.multipleBitsInput.rippleCarry.RippleCarryAdder;

public abstract class AbstractTwoBitsRCA extends RippleCarryAdder
{
	protected static final int INPUT_COL_A1 = 0;
	protected static final int INPUT_COL_A0 = 1;
	protected static final int INPUT_COL_B1 = 2;
	protected static final int INPUT_COL_B0 = 3;
	protected static final int OUTPUT_COL_CARRY = 4;
	protected static final int OUTPUT_COL_S1 = 5;
	protected static final int OUTPUT_COL_S0 = 6;

	protected static final int S1 = 1;
	protected static final int S0 = 2;

	private static final int NUMBER_OF_INPUTS = 4;
	private static final int NUMBER_OF_OUTPUTS = 3;
	private static final String[] COLUMN_NAMES = new String[]
	{
		"A1",
		"A0",
		"B1",
		"B0",
		"CARRY OUT",
		"S1",
		"S0"
	};

	public AbstractTwoBitsRCA()
	{
		super.setNumberOfInputs( NUMBER_OF_INPUTS );
		super.setNumberOfOutputs( NUMBER_OF_OUTPUTS );
		super.setColumnNames( COLUMN_NAMES );
	}
	
	@Override
	protected void populateTruthTable( byte[][] data )
	{
		int row = 0;
		for( byte A1 : Binary.VALUES )
		{
			for( byte A0 : Binary.VALUES )
			{
				for( byte B1 : Binary.VALUES )
				{
					for( byte B0 : Binary.VALUES )
					{
						this.populateTableRow( data, row, new byte[]{ A1, A0, B1, B0 } );
						row++;
					}
				}
			}
		}
	}

	@Override
	protected void populateTableRow( byte[][] data, int row, byte[] input )
	{
		byte[] output = this.out( input );

		data[ row ][ INPUT_COL_A1 ] = input[ INPUT_COL_A1 ];
		data[ row ][ INPUT_COL_A0 ] = input[ INPUT_COL_A0 ];
		data[ row ][ INPUT_COL_B1 ] = input[ INPUT_COL_B1 ];
		data[ row ][ INPUT_COL_B0 ] = input[ INPUT_COL_B0 ];
		data[ row ][ OUTPUT_COL_CARRY ] = output[ CARRY_OUT ];
		data[ row ][ OUTPUT_COL_S1 ] = output[ S1 ];
		data[ row ][ OUTPUT_COL_S0 ] = output[ S0 ];
	}

	public byte[] out( byte A1, byte A0, byte B1, byte B0 )
	{
		return this.out( new byte[]{ A1, A0, B1, B0 } );
	}

	public byte[] out( int A1, int A0, int B1, int B0 )
	{
		return this.out( (byte) A1, (byte) A0, (byte) B1, (byte) B0 );
	}
}
