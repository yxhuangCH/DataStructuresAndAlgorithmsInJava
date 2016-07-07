package com.yxhuang.java.arrays;

import java.util.Iterator;

/**
 *  Demonstrates ordered array class
 * @author Administrator
 *
 */
public class OrderedArray {
	private long[] a;
	private int nElemts;
	
	public OrderedArray(int max){
		a = new long[max];
		nElemts = 0;
	}
	
	public int size(){
		return nElemts;
	}
	
	/**
	 *  Find by a binary search
	 * @param searchKey
	 * @return
	 */
	public int find(long searchKey){
		int lowerBound = 0;
		int upperBound = nElemts - 1;
		int curIn;
		
		while (true) {
			curIn = (lowerBound + upperBound) / 2;
			if (a[curIn] == searchKey) {
				return curIn;
			} else if (lowerBound > upperBound) {  // can't find it
				return nElemts;
			} else {
				if (a[curIn] < searchKey) {
					lowerBound = curIn + 1;
				} else {
					upperBound = curIn - 1;
				}
			}
		}
	}
	
	public void insert(long value){
		int j;
		for (j = 0; j < nElemts; j++) {
			if (a[j] > value) {
				break;
			}
		}
		
		for (int k = nElemts; k > j; k--) {
			a[k] = a[k - 1];
		}
		
		a[j] = value;
		nElemts++;
	}
	
	public boolean delete(long value){
		int j = find(value);
		if (j == nElemts) {
			return false;
		} else {
			for (int k = j; k < nElemts; k++) {
				a[k] = a[k + 1];
			}
			 
			nElemts--;
			return true;
		}
	}
	
	public void display(){
		for(int j = 0; j < nElemts; j++){
			System.out.print(a[j] + " ");
		}
		System.out.println("");
	}

}
