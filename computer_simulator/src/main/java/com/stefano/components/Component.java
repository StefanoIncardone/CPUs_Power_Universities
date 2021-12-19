package com.stefano.components;

public interface Component
{
	String[] getTruthTableColumnNames();
	
	int[][] getTable();

	void populateTruthTable( int[][] data );

	void populateTableRow( int[][] data, int row, int[] input );

	int[] out( int[] input );
}
