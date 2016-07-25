package com.yxhuang.java.resursion;

import java.awt.DisplayMode;

/**
 *  Demonstrates merging two arrays into a third
 * @author Administrator
 *
 */
public class Merge {
	
	public static void main(String[] args) {
		int[] arrayA = {23, 47, 81, 95};
		int[] arrayB = {7, 14, 39, 55, 62, 74};
		int[] arrayC = new int[10];
		
		merge(arrayA, 4, arrayB, 6, arrayC);
		display(arrayC, 10);
	}
	
	private static void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC){
		int arrayAIndex = 0, arrayBIndex = 0, arrayCIndex = 0;
		
		while(arrayAIndex < sizeA && arrayBIndex < sizeB){  // neither array empty
			if (arrayA[arrayAIndex] < arrayB[arrayBIndex]) {
				arrayC[arrayCIndex++] = arrayA[arrayAIndex++];
			} else {
				arrayC[arrayCIndex++] = arrayB[arrayBIndex++];
			}
		}
		
		while(arrayAIndex < sizeA){	// arrayB is empty, but arrayA isn't
			arrayC[arrayCIndex++] = arrayA[arrayAIndex++];
		}
		
		while(arrayBIndex < sizeB){ // arrayA is empty, but arrayB isn't
			arrayC[arrayCIndex++] = arrayB[arrayBIndex++];
		}
	}
	
	private static void display(int[] arrayC, int sizeC){
		for(int i = 0; i < sizeC; i++){
			System.out.print(arrayC[i] + " ");
		}
		System.out.println("");
	}
}
