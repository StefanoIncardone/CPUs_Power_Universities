package com.stefano;

import com.stefano.components.logicGates.Gate;
import com.stefano.components.logicGates.doubleInput.*;
import com.stefano.components.logicGates.singleInput.*;

public class CPU 
{
	public static void main( String[] args )
	{
		System.out.println
		(
														"\n" +
			Gate.truthTable( TAUTOLOGY.class )		+	"\n" +
			Gate.truthTable( CONTRADICTION.class )	+	"\n" +
			Gate.truthTable( BUFFER.class )			+	"\n" +
			Gate.truthTable( NOT.class )			+	"\n" +
			Gate.truthTable( OR.class )				+	"\n" +
			Gate.truthTable( NOR.class )			+	"\n" +
			Gate.truthTable( AND.class )			+	"\n" +
			Gate.truthTable( NAND.class )			+	"\n" +
			Gate.truthTable( XOR.class )			+	"\n" +
			Gate.truthTable( XNOR.class )			+	"\n" +
			Gate.truthTable( IMPLY.class )			+	"\n" +
			Gate.truthTable( NIMPLY.class )			+	"\n"
		);
	}
}
