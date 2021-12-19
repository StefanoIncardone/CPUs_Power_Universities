package com.stefano;

import com.stefano.binary.TruthTable;
import com.stefano.components.logicGates.doubleInput.*;
import com.stefano.components.logicGates.singleInput.*;
import com.stefano.components.math.adders.HalfAdder;

public class CPU 
{
	public static void main( String[] args )
	{
		System.out.println
		(
															"\n" +
			TruthTable.create( new TAUTOLOGY() )		+	"\n" +
			TruthTable.create( new CONTRADICTION() )	+	"\n" +
			TruthTable.create( new BUFFER() )			+	"\n" +
			TruthTable.create( new NOT() )				+	"\n" +
			TruthTable.create( new OR() )				+	"\n" +
			TruthTable.create( new NOR() )				+	"\n" +
			TruthTable.create( new XOR() )				+	"\n" +
			TruthTable.create( new XNOR() )				+	"\n" +
			TruthTable.create( new AND() )				+	"\n" +
			TruthTable.create( new NAND() )				+	"\n" +
			TruthTable.create( new IMPLY() )			+	"\n" +
			TruthTable.create( new NIMPLY() )			+	"\n" +
			TruthTable.create( new HalfAdder() )			+	"\n"
		);
	}
}
