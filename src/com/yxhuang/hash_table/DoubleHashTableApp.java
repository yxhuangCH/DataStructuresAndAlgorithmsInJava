package com.yxhuang.hash_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DoubleHashTableApp {
	public static void main(String[] args) throws IOException {
		int aKey;
		DataItem aDataItem;
		int size, n;
		
		System.out.print("Enter size of hash table:  ");
		size = getInt();
		System.out.print("Enter inital number of items: ");
		n = getInt();
		
		DoubleHash hashTable = new DoubleHash(size);
		
		for(int i =0; i < n; i++){
			aKey = (int) (Math.random() * 2 * size);
			aDataItem = new DataItem(aKey);
			hashTable.insert(aKey, aDataItem);
		}
		
		//  interact with user
		while(true){
			System.out.print("Enter first letter of  ");
			System.out.print("show,  insert, delete, or find: ");
			char choice = getChar();
			switch (choice) {
			case 's':
				hashTable.displayTable();
				break;
				
			case 'i':
				System.out.print("Entry key value to insert: ");
				aKey = getInt();
				aDataItem = new DataItem(aKey);
				hashTable.insert(aKey, aDataItem);
				break;
				
			case 'd':
				System.out.print("Entry key value to delete: ");
				aKey = getInt();
				hashTable.delete(aKey);
				break;
				
			case 'f':
				System.out.print("Entry key value to find: ");
				aKey = getInt();
				aDataItem = hashTable.find(aKey);
				if (aDataItem != null) {
					System.out.println("Found " + aKey);
				} else {
					System.out.println("Counld not find " + aKey);
				}
			default:
				System.out.print("Invalid entry\n");
				break;
			}
		}
	}

	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String string = br.readLine();
		return string;
	}
	
	public static char getChar() throws IOException{
		String s = getString();
		return s.charAt(0);
	}
	
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}
}
