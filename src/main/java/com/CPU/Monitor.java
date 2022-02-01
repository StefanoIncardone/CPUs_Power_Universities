package com.CPU;

import com.CPU.components.Component;
import com.CPU.components.ALU.adders.multipleBitInputs.fourBit.FourBitsRCA;
import com.CPU.components.ALU.adders.multipleBitInputs.twoBit.TwoBitsRCA;
import com.CPU.components.ALU.adders.oneBitInputs.full.FullAdder;
import com.CPU.components.ALU.adders.oneBitInputs.half.HalfAdder;
import com.CPU.components.ALU.comparators.oneBit.OneBitComparator;
import com.CPU.components.ALU.multipliers.twoBit.TwoBitMultiplier;
import com.CPU.components.logicGates.oneBitInput.*;
import com.CPU.components.logicGates.twoBitsInput.*;

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
