package com.yxhuang.hash_table;

/**
 * Demonstrates hash table with linear probing.
 * @author Administrator
 *
 */
public class LinearProbeHashTable {
	private DataItem[] hashArray; 	// array holds hash table
	private int arraySize;
	private  DataItem nonItem;		// for deleted items
	
	public LinearProbeHashTable(int size){
		arraySize = size;
		hashArray = new DataItem[arraySize];
		nonItem = new DataItem(-1);			// deleted item key is -1
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

	public int hashFunc(int key){
		return key % arraySize;			// hash function
	}
	
	public void insert(DataItem item){
		// assume table not full
		int key = item.getKey();
		// hash the key until empty cell or -1
		int hashVal = hashFunc(key);		
		while(hashArray[hashVal] != null &&
				hashArray[hashVal].getKey() != -1){
			++hashVal;			// go to next cell
			hashVal %= arraySize;		// wraparound if necessary
		}
		hashArray[hashVal] = item;		// insert item
	}
	
	public DataItem delete(int key){
		int hashVal = hashFunc(key);
		while(hashArray[hashVal] != null){
			if (hashArray[hashVal].getKey() == key) {
				DataItem temp = hashArray[hashVal];
				hashArray[hashVal] = nonItem;
				return temp;
			}
			++hashVal;
			hashVal %= arraySize;
		}
		return null;				// can't find item
	}
	
	public DataItem find(int key){
		int hashVal = hashFunc(key);
		
		while(hashArray[hashVal] != null ){
			if (hashArray[hashVal].getKey() == key) {
				return hashArray[hashVal];
			}
			++hashVal;
			hashVal %= arraySize;
		}
		return null;
	}
}


