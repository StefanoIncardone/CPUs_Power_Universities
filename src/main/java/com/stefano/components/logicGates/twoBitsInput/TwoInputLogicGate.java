package com.stefano.components.logicGates.twoBitsInput;

import com.stefano.binary.Binary;
import com.stefano.components.logicGates.LogicGate;

public abstract class TwoInputLogicGate extends LogicGate
{
	protected static final int INPUT_COL_A = 0;
	protected static final int INPUT_COL_B = 1;
	protected static final int OUTPUT_COL = 2;

	private static final int NUMBER_OF_INPUTS = 2;
	private final String[] COLUMN_NAMES = new String[]
	{
		"A", 
		"B",
		"A " + this.getClass().getSimpleName() + " B"
	};

	public TwoInputLogicGate()
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
		data[ row ][ INPUT_COL_A ] = input[ INPUT_COL_A ];
		data[ row ][ INPUT_COL_B ] = input[ INPUT_COL_B ];
		data[ row ][ OUTPUT_COL ] = this.out( input )[ OUTPUT ];
	}

	public byte out( byte A, byte B )
	{
		return this.out( new byte[]{ A, B } )[ OUTPUT ];
	}

	public byte out( int A, int B )
	{
		return this.out( (byte) A, (byte) B );
	}
}
