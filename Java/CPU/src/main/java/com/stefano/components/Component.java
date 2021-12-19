package com.stefano.components;

public interface Component
{
	public abstract String[] getTruthTableColumnNames();
	
	public abstract int[][] getTable();

	public abstract void populateTruthTable( int[][] data );

	public abstract void populateTableRow( int[][] data, int row, int[] input );

	public abstract int[] out( int[] input );
}
