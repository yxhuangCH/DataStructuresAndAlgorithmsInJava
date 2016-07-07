package com.yxhuang.java.simpleSorting;

/**
 *  Demonstrates bubble sort
 *  用来说明冒泡排序
 */
public class ArrayBubbleSort {
	private long[] a;
	private int nElems;
	
	public ArrayBubbleSort(int max){
		a = new long[max];
		nElems = 0;
	}
	
	public void insert(long value){
		a[nElems] = value;
		nElems++;
	}
	
	public void display(){
		for (int i = 0; i < nElems; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println(" ");
	}
	
	public void bubbleSort(){
		int out, in;
		for (out = nElems - 1; out > 1; out--) {  // outer loop 
			for (in = 0; in < out; in++) {  // inner loop
				if (a[in] > a[in + 1]) {
					swap(in, in + 1);
				}
			}
		}
	}
	
	private void swap(int one, int two){
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}
