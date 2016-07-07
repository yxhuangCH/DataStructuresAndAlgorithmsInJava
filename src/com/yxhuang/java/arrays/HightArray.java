package com.yxhuang.java.arrays;

/**
 *  Demonstrates array class with hight - level interfac
 *  to run this program.
 * @author Administrator
 *
 */
public class HightArray {
	private long[] a;
	private int nElems;
	
	public HightArray(int max){
		a = new long[max];
		nElems = 0;
	}
	
	public boolean find(long searchKey){
		int j;
		for (j = 0; j < nElems; j++) {
			if (a[j] == searchKey) {
				break;
			}
		}
		
		if (j == nElems) {
			return false;
		} else {
			return true;
		}
	}
	
	public void insert(long value){
		a[nElems] = value;
		nElems++;
	}
	
	public boolean delete(long value){
		int j;
		for (j = 0; j < nElems; j++) {
			if (a[j] == value) {
				break;
			}
		}
		
		if (j == nElems) {
			return false;
		} else {
			for (int k = j; k < nElems; k++) {
				a[k] = a[k + 1];
			}
			
			nElems--;
			return true;
		}
	}
	
	public void display(){
		for (int j = 0; j < nElems; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.println("");
	}
}  // end of Hight class













