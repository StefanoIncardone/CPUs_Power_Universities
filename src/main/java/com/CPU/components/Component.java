package com.CPU.components;

import com.CPU.components.ALU.adders.Adder;
import com.CPU.components.ALU.comparators.Comparator;
import com.CPU.components.ALU.multipliers.Multiplier;
import com.CPU.components.logicGates.LogicGate;
import com.libraries.TruthTable;
import com.libraries.exceptions.InputAmountException;
import com.libraries.exceptions.NonBinaryNumberException;
import com.libraries.utilityClasses.Binary;

public abstract sealed class Component permits LogicGate, Adder, Multiplier, Comparator
{
	private final int NUMBER_OF_INPUTS;
	private final int NUMBER_OF_OUTPUTS;
	private final String[] COLUMN_NAMES;
	
	private TruthTable truthTable;
	
	protected Component( int numberOfInputs, int numberOfOutputs, String[] columnNames )
	{
		NUMBER_OF_INPUTS = numberOfInputs;
		NUMBER_OF_OUTPUTS = numberOfOutputs;
		COLUMN_NAMES = columnNames;
		this.truthTable = null;
	}

	public final int getNumberOfInputs()
	{
		return NUMBER_OF_INPUTS;
	}

	public final int getNumberOfOutputs()
	{
		return NUMBER_OF_OUTPUTS;
	}

	public final String[] getColumnNames()
	{
		return COLUMN_NAMES;
	}

	public final String getTruthTable()
	{
		if( truthTable == null )
		{
			truthTable = new TruthTable( this );
		}
		
		return truthTable.toString();
	}

	protected final void validateInput( byte[] input )
	{
		if( !Binary.isValid( input ) )
		{
			throw new IllegalArgumentException( "input contains non-binary numbers (0/1)" );
		}
		else if( input.length != NUMBER_OF_INPUTS )
		{
			throw new InputAmountException( input.length, this );
		}
	}
	
	public abstract byte[] out( byte... inputs );
}