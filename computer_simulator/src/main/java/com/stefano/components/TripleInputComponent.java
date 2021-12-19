package com.stefano.components;

public interface TripleInputComponent extends Component
{
	int NUMBER_OF_INPUTS = 3;
	int TRUTH_TABLE_ROWS = (int) Math.pow( 2, NUMBER_OF_INPUTS );
}