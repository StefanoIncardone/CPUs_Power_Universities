package com.CPU.components;

import com.CPU.components.ALU.adders.multipleBitInputs.RippleCarryAdder;
import com.CPU.components.ALU.adders.oneBitInputs.OneBitAdder;
import com.CPU.components.ALU.comparators.Comparator;
import com.CPU.components.logicGates.LogicGate;

public abstract sealed class Component permits LogicGate, OneBitAdder, RippleCarryAdder, Comparator
{
	private final Properties properties;
	
	private TruthTable truthTable;
	
	protected Component( int numberOfInputs, int numberOfOutputs, String[] columnNames )
	{
		properties = new Properties( numberOfInputs, numberOfOutputs, columnNames );
		this.truthTable = null;
	}

	public final int getNumberOfInputs()
	{
		return properties.numberOfInputs();
	}

	public final int getNumberOfOutputs()
	{
		return properties.numberOfOutputs();
	}

	public final String[] getColumnNames()
	{
		return properties.columnNames();
	}

	public final String getTruthTable()
	{
		if( truthTable == null )
		{
			truthTable = new TruthTable( this );
		}
		
		return truthTable.toString();
	}
	
	protected abstract byte[] out( byte[] inputs );
}

record Properties( int numberOfInputs, int numberOfOutputs, String[] columnNames ) {}