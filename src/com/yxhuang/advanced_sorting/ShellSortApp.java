package com.yxhuang.advanced_sorting;

public class ShellSortApp {
	
	public static void main(String[] args) {
		int maxsize = 10;
		ShellArray array = new ShellArray(maxsize);
		
//		for (int i = 0; i < maxsize; i++) {
//			long n = (long) (Math.random() * 99);
//			array.insert(n);
//		}
		
		array.insert(7);
		array.insert(10);
		array.insert(1);
		array.insert(9);
		array.insert(2);
		array.insert(5);
		array.insert(8);
		array.insert(6);
		array.insert(4);
		array.insert(3);
		
		array.display();
		
		array.shellSort();
		
		array.display();
	
	}

}
