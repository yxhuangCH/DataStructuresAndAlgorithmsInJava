package com.yxhuang.hash_table;

/**
 * Demonstrates hash table with double hashing.
 * @author Administrator
 *
 */
public class DoubleHash {
	private DataItem[] hashArray;
	private int arraySize;
	private DataItem nonDataItem;   // for deleted items
	
	public DoubleHash(int size){
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonDataItem = new DataItem(-1);
	}
	
	public void displayTable(){
		System.out.print("Table: ");
		for(int i = 0; i < arraySize; i++){
			if (hashArray[i] != null) {
				System.out.print(hashArray[i].getKey() + "   ");
			} else {
				System.out.print("** ");
			}
		}
		System.out.println("");
	}
	
	public int hashFunc1(int key){
		return key % arraySize;
	}
	
	public int hashFunc2(int key){
		// non-zero, less than array size, different from hF1
		// array size must be relatively prime to 5, 4, 3 and 2
		// stepSize = constant - (key & constant)
		return 5 - key % 5;
	}
	
	public void insert(int key, DataItem item){
		// assume table not full
		int hashVal = hashFunc1(key);
		int stepSize = hashFunc2(key);	// get step size
		while(hashArray[hashVal] != null &&
				hashArray[hashVal].getKey() != -1){
			hashVal += stepSize;
			hashVal %= arraySize;
		}
		hashArray[hashVal] = item;
	}
	
	public DataItem delete(int key){
		int hashVal = hashFunc1(key);
		int stepSize = hashFunc2(key);
		while(hashArray[hashVal] != null){
			if (hashArray[hashVal].getKey() == key) {
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonDataItem;
				return temp;
			}
			hashVal +=stepSize;
			hashVal %= arraySize;
		}
		return null; 		// can't find item
	}
	
	public DataItem find(int key){
		// assume table not full
		int hashVal = hashFunc1(key);
		int stepSize = hashFunc2(key);
		while(hashArray[hashVal] != null){
			if (hashArray[hashVal].getKey() == key) {
				return hashArray[hashVal];   
			}
			hashVal += stepSize;
			hashVal %=arraySize;
		}
		return null;
	}
}