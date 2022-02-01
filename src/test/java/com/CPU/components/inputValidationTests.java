package com.CPU.components;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import com.CPU.components.ALU.adders.multipleBitInputs.fourBit.FourBitsRCA;
import com.CPU.components.ALU.adders.multipleBitInputs.twoBit.TwoBitsRCA;
import com.CPU.components.ALU.adders.oneBitInputs.full.FullAdder;
import com.CPU.components.ALU.adders.oneBitInputs.half.HalfAdder;
import com.CPU.components.ALU.comparators.oneBit.OneBitComparator;
import com.CPU.components.ALU.multipliers.twoBit.TwoBitMultiplier;
import com.CPU.components.logicGates.oneBitInput.*;
import com.CPU.components.logicGates.twoBitsInput.*;

import org.junit.Test;

public class inputValidationTests
{
	private static final Component[] COMPONENTS = new Component[]
	{
		// logic gates
		new CONTRADICTION(),
		new TAUTOLOGY(),
		new BUFFER(),
		new NOT(),
		new OR(),
		new NOR(),
		new XOR(),
		new XNOR(),
		new AND(),
		new NAND(),
		new IMPLY(),
		new CIMPLY(),
		new NIMPLY(),
		new CNIMPLY(),
		
		// adders
			// one bit input
			new HalfAdder(),
			new FullAdder(),

			// multiple bit input
			new TwoBitsRCA(),
			new FourBitsRCA(),

		// comparators
		new OneBitComparator(),

		// multipliers
		new TwoBitMultiplier()
	};

	@Test
	public void componentShouldRaiseAnErrorWhenPassedNonBinaryValues()
	{
		boolean isInputCorrect = true;

		for( Component component : COMPONENTS )
		{
			try
			{
				testOutputInputBinaryValues( component );
			}
			catch( IllegalArgumentException exception )
			{
				isInputCorrect = false;
			}

			assertEquals( isInputCorrect, false );

			isInputCorrect = true;
		}
	}

	@Test
	public void componentShouldRaiseAnErrorWhenPassedWrongAmountOfInputs()
	{
		boolean isInputCorrect = true;

		for( Component component : COMPONENTS )
		{
			try
			{
				testOutputInputLength( component );
			}
			catch( IllegalArgumentException exception )
			{
				isInputCorrect = false;
			}

			assertEquals( isInputCorrect, false );

			isInputCorrect = true;
		}
	}

	private void testOutputInputLength( Component component )
	{
		byte[] input = new byte[ randomIntExclude( component.getNumberOfInputs() ) ];

		for( int index = 0; index < input.length; index++ )
		{
			input[ index ] = 1;
		}
		
		component.out( input );
	}
	
	private void testOutputInputBinaryValues( Component component )
	{
		byte[] input = new byte[ component.getNumberOfInputs() ];
		Random randomGenerator = new Random();
		
		for( int index = 0; index < input.length; index++ )
		{
			input[ index ] = (byte) randomGenerator.nextInt( 2, Byte.MAX_VALUE + 1 );
		}

		component.out( input );
	}

	private int randomIntExclude( int excluded )
	{
		Random randomGenerator = new Random();
		
		int number;
		do
		{
			number = randomGenerator.nextInt( Byte.MAX_VALUE );
		}
		while( number == excluded );
		
		return number;
	}
}
