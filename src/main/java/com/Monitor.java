package com;

import com.CPU.components.Component;
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

public class Monitor
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

	public static void main( String[] args )
	{
		for( Component component : COMPONENTS )
		{
			System.out.println
			(
																			"\n" +
				"Component: " + component.getClass().getSimpleName()	+	"\n" +
				component.getTruthTable()								+	"\n"
			);
		}
	}
}
