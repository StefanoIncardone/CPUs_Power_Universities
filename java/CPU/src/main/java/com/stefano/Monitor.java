package com.stefano;

import com.stefano.components.Component;
import com.stefano.components.ALU.adders.multipleBitsInput.rippleCarry.twoBits.TwoBitsRCA;
import com.stefano.components.ALU.adders.singleBitInput.full.FullAdder;
import com.stefano.components.ALU.adders.singleBitInput.half.HalfAdder;
import com.stefano.components.ALU.comparators.oneBit.OneBitComparator;
import com.stefano.components.logicGates.oneBitInput.*;
import com.stefano.components.logicGates.twoBitsInput.*;

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
			System.out.print( "\n" + component.getTruthTable() + "\n" );
		}
	}
}
