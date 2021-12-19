package com.stefano.components;

public interface SingleInputComponent extends Component
{
	int NUMBER_OF_INPUTS = 1;
	int TRUTH_TABLE_ROWS = (int) Math.pow( 2, NUMBER_OF_INPUTS );
}
