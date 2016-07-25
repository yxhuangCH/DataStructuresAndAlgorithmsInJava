package com.yxhuang.java.resursion;


public class MergeSortApp {
		
	public static void main(String[] args) {
		int maxSize =100;
		MergeSortArray array = new MergeSortArray(maxSize);
		
		array.intsert(64);
		array.intsert(21);
		array.intsert(33);
		array.intsert(70);
		array.intsert(12);
		array.intsert(85);
		array.intsert(44);
		array.intsert(3);
		array.intsert(99);
		array.intsert(0);
		array.intsert(108);
		array.intsert(36);
		
		array.display();
		
		array.mergeSort();
		array.display();
	}
}
