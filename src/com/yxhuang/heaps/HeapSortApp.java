package com.yxhuang.heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapSortApp {
	public static void main(String[] args) throws IOException {
		int size, j;
		System.out.print("Enter number of items: ");
		size = getInt();
		HeapSort heap = new HeapSort(size);
		
		// fill array with random nodes
		for(j = 0; j < size; j++){
			int random = (int) (Math.random() * 100);
			Node newNode = new Node(random);
			heap.insertAt(j, newNode);
			heap.incrementSize();
		}
		
		// display random array
		System.out.print("Random: " );
		heap.displayArray();
		
		// make random array into heap
		for(j = size / 2 -1; j >= 0; j--){
			heap.trickleDown(j);
		}
		
		System.out.println("Heap: ");
		heap.displayArray();
		heap.displayHeap();
		
		// remove from heap and  store at array end
		for(j = size -1; j >= 0; j--){
			Node biggestNode = heap.remove();
			heap.insertAt(j, biggestNode);
		}
		
		System.out.println("Sorted: ");
		heap.displayArray();
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
