package com.yxhuang.binary_trees;

public class Node {
	public int iData;			// date item(key)
	public double dDate;		// data item
	public Node leftChild;			// this node's left child
	public Node rightChild;		// this node's right child
	
	public Node(){
		
	}
	
	public void displayNode(){
		System.out.print('{');
		System.out.print(iData);
		System.out.print(",  ");
		System.out.print(dDate);
		System.out.print("}");
	}
	
}
