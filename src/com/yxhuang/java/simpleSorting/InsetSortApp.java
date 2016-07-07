package com.yxhuang.java.simpleSorting;

import java.util.Vector;
import java.util.zip.CRC32;

public class InsetSortApp {
	public static void main(String[] args) {
		int mazSize = 100;
		ArrayInsertSort array = new ArrayInsertSort(mazSize);
		
		array.insert(77);
		array.insert(99);
		array.insert(44);
		array.insert(55);
		array.insert(22);
		array.insert(88);
		array.insert(11);
		array.insert(00);
		array.insert(66);
		array.insert(33);
		
		array.display();
		
		array.insertionSort();
		array.display();
	}
}







