package com.stefano;

import com.stefano.components.Component;
import com.stefano.components.ALU.adders.multipleBitInputs.rippleCarry.RCA.twoBits.TwoBitsRCA;
import com.stefano.components.ALU.adders.oneBitInputs.full.FullAdder;
import com.stefano.components.ALU.adders.oneBitInputs.half.HalfAdder;
import com.stefano.components.ALU.comparators.oneBit.OneBitComparator;
import com.stefano.components.logicGates.gates.oneBitInput.BUFFER;
import com.stefano.components.logicGates.gates.oneBitInput.CONTRADICTION;
import com.stefano.components.logicGates.gates.oneBitInput.NOT;
import com.stefano.components.logicGates.gates.oneBitInput.TAUTOLOGY;
import com.stefano.components.logicGates.gates.twoBitsInput.AND;
import com.stefano.components.logicGates.gates.twoBitsInput.CIMPLY;
import com.stefano.components.logicGates.gates.twoBitsInput.CNIMPLY;
import com.stefano.components.logicGates.gates.twoBitsInput.IMPLY;
import com.stefano.components.logicGates.gates.twoBitsInput.NAND;
import com.stefano.components.logicGates.gates.twoBitsInput.NIMPLY;
import com.stefano.components.logicGates.gates.twoBitsInput.NOR;
import com.stefano.components.logicGates.gates.twoBitsInput.OR;
import com.stefano.components.logicGates.gates.twoBitsInput.XNOR;
import com.stefano.components.logicGates.gates.twoBitsInput.XOR;

public class Monitor
{
	private static final Component[] COMPONENTS = new Component[]
	{
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
		
		new HalfAdder(),
		new FullAdder(),

		new TwoBitsRCA(),

		new OneBitComparator()
	};

	public static void main( String[] args )
	{
		for( Component component : COMPONENTS )
		{
			System.out.println( "\n" + component.getTruthTable() + "\n" );
		}
	}
}
