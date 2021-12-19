package com.stefano.components;

public interface Component
{
	public abstract String[] getTruthTableColumnNames();
	
	public abstract int[][] getTable();
}
