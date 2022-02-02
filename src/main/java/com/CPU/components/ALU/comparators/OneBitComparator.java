package com.CPU.components.ALU.comparators;

import com.CPU.components.logicGates.twoBitsInput.CIMPLY;
import com.CPU.components.logicGates.twoBitsInput.CNIMPLY;
import com.CPU.components.logicGates.twoBitsInput.IMPLY;
import com.CPU.components.logicGates.twoBitsInput.NIMPLY;
import com.CPU.components.logicGates.twoBitsInput.XNOR;

public final class OneBitComparator extends Comparator
{
	public static final int INPUT_COL_A = 0;
	public static final int INPUT_COL_B = 1;
	public static final int OUTPUT_COL_LESS = 2;
	public static final int OUTPUT_COL_LESS_OR_EQUAL = 3;
	public static final int OUTPUT_COL_EQUAL = 4;
	public static final int OUTPUT_COL_GREATER_OR_EQUAL = 5;
	public static final int OUTPUT_COL_GREATER = 6;

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

	private final CNIMPLY cnimply = new CNIMPLY();
	private final IMPLY imply = new IMPLY();
	private final XNOR xnor = new XNOR();
	private final CIMPLY cimply = new CIMPLY();
	private final NIMPLY nimply = new NIMPLY();

	public OneBitComparator()
	{
		super( NUMBER_OF_INPUTS, COLUMN_NAMES );
	}

	public final byte[] out( byte A, byte B )
	{
		return this.out( new byte[]{ A, B } );
	}

	public final byte[] out( int A, int B )
	{
		return this.out( (byte) A, (byte) B );
	}

	@Override
	protected byte[] out( byte... inputs )
	{
		validateInput( inputs );

		byte A = inputs[ INPUT_COL_A ];
		byte B = inputs[ INPUT_COL_B ];

		byte lessOutput = cnimply.out( A, B );
		byte lessOrEqualOutput = imply.out( A, B );
		byte equalOutput = xnor.out( A, B );
		byte greaterOrEqualOutput = cimply.out( A, B );
		byte greaterOutput = nimply.out( A, B );

		return new byte[]{ lessOutput, lessOrEqualOutput, equalOutput, greaterOrEqualOutput, greaterOutput };
	}
}
