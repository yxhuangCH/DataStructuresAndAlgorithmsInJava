package com.yxhuang.heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HeapApp {
	public static void main(String[] args) throws IOException {
		int value, value2;
		Heap heap = new Heap(31);
		boolean success;
		
		heap.insert(70);
		heap.insert(40);
		heap.insert(50);
		heap.insert(20);
		heap.insert(60);
		heap.insert(100);
		heap.insert(80);
		heap.insert(30);
		heap.insert(10);
		heap.insert(90);
		
		//  interact with user
		while(true){
			System.out.print("Enter first letter of  ");
			System.out.print("show,  insert, delete, or find: ");
			char choice = getChar();
			switch (choice) {
			case 's':
				heap.displayHeap();
				break;
				
			case 'i':
				System.out.print("Entry key value to insert: ");
				value = getInt();
				success = heap.insert(value);
				if (!success) {
					System.out.println("Can't insert; heap full");
				}
				break;
				
			case 'd':
				if (!heap.isEmpty()) {
					heap.remove();
				} else {
					System.out.println("Can't remove; heap is empty");
				}
				break;
				
			case 'c':     // change
				System.out.print("Entry current value to find: ");
				value = getInt();
				System.out.print("Entry new key: ");
				value2 = getInt();
				success = heap.change(value, value2);
				if (!success) {
					System.out.println("Invalid index");
				} 
				break;
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
