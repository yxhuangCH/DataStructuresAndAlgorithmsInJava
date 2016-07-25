package com.yxhuang.java.resursion;

import javax.sql.rowset.serial.SerialArray;

/**
 *  Demonstrates recursive binary search
 * @author Administrator
 *
 */
public class BinarySearch {
	
	public static void main(String[] args) {
		int max = 100;
		ordArray array = new ordArray(max);
		
		array.insert(72);
		array.insert(90);
		array.insert(45);
		array.insert(126);
		array.insert(54);
		array.insert(99);
		array.insert(144);
		array.insert(27);
		array.insert(135);
		array.insert(81);
		array.insert(18);
		array.insert(108);
		array.insert(9);
		array.insert(117);
		array.insert(63);
		array.insert(36);
		
		array.display();
		
		int searchKey = 27;
		if(array.find(searchKey) != array.size()){
			System.out.println("Foud " + searchKey);
		} else {
			System.out.println("Can't find " + searchKey);
		}
	}
}
