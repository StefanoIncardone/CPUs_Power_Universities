package com.CPU;

import com.CPU.components.Component;
import com.CPU.components.ALU.adders.multipleBitInputs.twoBits.TwoBitsRCA;
import com.CPU.components.ALU.adders.oneBitInputs.full.FullAdder;
import com.CPU.components.ALU.adders.oneBitInputs.half.HalfAdder;
import com.CPU.components.ALU.comparators.oneBit.OneBitComparator;
import com.CPU.components.logicGates.gates.oneBitInput.BUFFER;
import com.CPU.components.logicGates.gates.oneBitInput.CONTRADICTION;
import com.CPU.components.logicGates.gates.oneBitInput.NOT;
import com.CPU.components.logicGates.gates.oneBitInput.TAUTOLOGY;
import com.CPU.components.logicGates.gates.twoBitsInput.AND;
import com.CPU.components.logicGates.gates.twoBitsInput.CIMPLY;
import com.CPU.components.logicGates.gates.twoBitsInput.CNIMPLY;
import com.CPU.components.logicGates.gates.twoBitsInput.IMPLY;
import com.CPU.components.logicGates.gates.twoBitsInput.NAND;
import com.CPU.components.logicGates.gates.twoBitsInput.NIMPLY;
import com.CPU.components.logicGates.gates.twoBitsInput.NOR;
import com.CPU.components.logicGates.gates.twoBitsInput.OR;
import com.CPU.components.logicGates.gates.twoBitsInput.XNOR;
import com.CPU.components.logicGates.gates.twoBitsInput.XOR;

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
		// for( Component component : COMPONENTS )
		// {
		// 	System.out.println( "\n" + component.getTruthTable() + "\n" );
		// }
	}
}
