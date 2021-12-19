package com.stefano.components;

public interface DoubleInputComponent extends Component
{
	int NUMBER_OF_INPUTS = 2;
	int TRUTH_TABLE_ROWS = (int) Math.pow( 2, NUMBER_OF_INPUTS );
}
