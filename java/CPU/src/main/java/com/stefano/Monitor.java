package com.stefano;

import com.stefano.components.Component;
import com.stefano.components.ALU.adders.multipleBitInputs.rippleCarry.bits_2.RCA_2bits;
import com.stefano.components.ALU.adders.singleBitInputs.full.FullAdder;
import com.stefano.components.ALU.adders.singleBitInputs.half.HalfAdder;
import com.stefano.components.logicGates.doubleInput.*;
import com.stefano.components.logicGates.singleInput.*;

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

		new RCA_2bits()
	};

	public static void main( String[] args )
	{
		for( Component component : COMPONENTS )
		{
			System.out.print( "\n" + component.getTruthTable() + "\n" );
		}
	}
}
