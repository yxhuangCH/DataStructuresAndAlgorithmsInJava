package com.yxhuang.java.resursion;

public class ordArray{
	private long[] a;
	private int nElems;
	
	public ordArray(int max){
		a = new long[max];
		nElems = 0;
	}
	
	public int size(){
		return nElems;
	}
	
	public int find(long searchKey){
		return recFind(searchKey, 0, nElems -1);
	}
	
	private int recFind(long searchKey, int lowerBound, int upperBound){
		int curIn;
		
		curIn = (lowerBound + upperBound) / 2;
		if (a[curIn] == searchKey) {
			return curIn;			// found it
		} else if (lowerBound > upperBound) {
			return nElems;			// can't found it
		} else {
			if (a[curIn] < searchKey) {  // it's in upper half
				return recFind(searchKey, curIn + 1, upperBound);
			} else { 	// it's in lower half
				return recFind(searchKey, lowerBound, curIn -1);
			}
		}
	} 
	
	public void insert(long value){
		int j;
		for (j = 0; j < nElems; j++) {
			if (a[j] > value) {  // linear search
				break;
			}
		}
		
		for (int k = nElems; k > j; k--) {  // move bigger ones up
			a[k] = a[k - 1];
		}
		
		a[j] = value;
		nElems++;
	}
	
	public void display(){
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.println("");
	}
}
