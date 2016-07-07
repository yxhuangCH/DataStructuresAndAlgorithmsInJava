package com.yxhuang.java.arrays;

public class LowArrayApp {
	public static void main(String[] args) {
		LowArray array = new LowArray(100);
		int nElems = 0;  // number of items in array
		int j;			// loop variable
		
		array.setElem(0, 77);
		array.setElem(1, 99);
		array.setElem(2, 44);
		array.setElem(3, 55);
		array.setElem(4, 22);
		array.setElem(5, 88);
		array.setElem(6, 11);
		array.setElem(7, 00);
		array.setElem(8, 66);
		array.setElem(9, 33);
		nElems = 10;
		
		// Display items
		for (j = 0; j < nElems; j++){
			System.out.print(array.getElem(j) + "  ");
		}
		System.out.println("");
		
		// search for data item
		int searchKey = 26;
		for (j = 0; j < nElems; j++) {
			if (array.getElem(j) == searchKey) {
				break;
			}
		}
		if (j == nElems) {
			System.out.println("Can't find " + searchKey);
		} else {
			System.out.println("Found " + searchKey);
		}
	}

}
