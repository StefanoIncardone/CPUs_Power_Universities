package com.stefano.components.logicGates.oneBitInput;

import com.stefano.binary.Binary;
import com.stefano.components.logicGates.LogicGate;

public abstract class OneInputLogicGate extends LogicGate
{
	protected static final int INPUT_COL = 0;
	protected static final int OUTPUT_COL = 1;

	@Override
	protected void setComponentAttributes()
	{
		super.NUMBER_OF_INPUTS = 1;

		super.COLUMN_NAMES = new String[]
		{
			"A", 
			this.getClass().getSimpleName() + " A"
		};
	}

	@Override
	protected void populateTruthTable( byte[][] data )
	{
		int row = 0;
		for( byte A : Binary.VALUES )
		{
			this.populateTableRow( data, row, new byte[]{ A } );
			row++;
		}
	}

	@Override
	protected void populateTableRow( byte[][] data, int row, byte[] input )
	{
		data[ row ][ INPUT_COL ] = input[ INPUT_COL ];
		data[ row ][ OUTPUT_COL ] = this.out( input )[ OUTPUT ];
	}

	public byte out( byte A )
	{
		return this.out( new byte[]{ A } )[ OUTPUT ];
	}

	public byte out( int A )
	{
		return this.out( (byte) A );
	}
}
