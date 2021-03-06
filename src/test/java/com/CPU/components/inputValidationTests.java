package com.CPU.components;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import com.CPU.components.ALU.adders.multipleBitInputs.FourBitsRCA;
import com.CPU.components.ALU.adders.multipleBitInputs.TwoBitsRCA;
import com.CPU.components.ALU.adders.oneBitInputs.FullAdder;
import com.CPU.components.ALU.adders.oneBitInputs.HalfAdder;
import com.CPU.components.ALU.comparators.OneBitComparator;
import com.CPU.components.ALU.multipliers.TwoBitMultiplier;
import com.CPU.components.logicGates.oneBitInput.BUFFER;
import com.CPU.components.logicGates.oneBitInput.CONTRADICTION;
import com.CPU.components.logicGates.oneBitInput.NOT;
import com.CPU.components.logicGates.oneBitInput.TAUTOLOGY;
import com.CPU.components.logicGates.twoBitsInput.AND;
import com.CPU.components.logicGates.twoBitsInput.CIMPLY;
import com.CPU.components.logicGates.twoBitsInput.CNIMPLY;
import com.CPU.components.logicGates.twoBitsInput.IMPLY;
import com.CPU.components.logicGates.twoBitsInput.NAND;
import com.CPU.components.logicGates.twoBitsInput.NIMPLY;
import com.CPU.components.logicGates.twoBitsInput.NOR;
import com.CPU.components.logicGates.twoBitsInput.OR;
import com.CPU.components.logicGates.twoBitsInput.XNOR;
import com.CPU.components.logicGates.twoBitsInput.XOR;

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
