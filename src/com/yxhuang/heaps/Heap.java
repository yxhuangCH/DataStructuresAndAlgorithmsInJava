package com.yxhuang.heaps;

/**
 *  Demonstrates heaps
 * @author Administrator
 *
 */
public class Heap {
	private Node[] heapArray;
	private int maxSize;
	private int currentSize;
	
	public Heap(int mx){
		maxSize = mx;
		currentSize = 0;
		heapArray = new Node[maxSize];
	}
	
	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	public boolean insert(int key){
		if (currentSize == maxSize) {
			return false;
		}
		
		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;
		trickleUp(currentSize++);
		return true;
	}
	
	public void trickleUp(int index){
		int parent = (index - 1) / 2;
		Node bottom = heapArray[index];
		while(index > 0 && heapArray[parent].getKey() < bottom.getKey()){
			heapArray[index] = heapArray[parent];  // move it down
			index = parent;
			parent = (parent - 1) / 2;
		}
		heapArray[index] = bottom;
	}
	
	public Node remove(){ 	// delete item with max key
		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return root;
	}
	
	public void trickleDown(int index){
		int largerChild;
		Node top = heapArray[index];
		while(index < currentSize / 2){  // while node has at least one child
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;
			if (rightChild < currentSize &&
					heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
				largerChild = rightChild;
			} else {
				largerChild = leftChild;
			}
			
			if (top.getKey() >= heapArray[largerChild].getKey()) {
				break;
			}
			
			heapArray[index] = heapArray[largerChild];
			index = largerChild;		// go down
		}
		
		heapArray[index] = top;		// root to index
	}
	
	public boolean change(int index, int newValue){
		if (index < 0 || index >= currentSize) {
			return false;
		}
		int oldValue = heapArray[index].getKey();		// remember old
		heapArray[index].setKey(newValue);   // change to new
		
		if (oldValue < newValue) { 	// if raised, trickle it up
			trickleUp(index);
		} else {		// if lowered, trickle it down
			trickleDown(index);
		}
		
		return true;
	}
	
	public void displayHeap(){
		System.out.println("heapArray: ");
		for (int i = 0; i < currentSize; i++) {
			if (heapArray[i] != null) {
				System.out.print(heapArray[i].getKey() + "  ");
			} else {
				System.out.println("---");
			}
		}
		
		System.out.println("");
		
		// heap format
		int nBlanks = 32;
		int itemsPerRow = 1;
		int colum = 0;
		int j = 0;		// current item
		String dots = "................................................................";
		System.out.println(dots + dots);
		
		while(currentSize > 0){
			if (colum == 0) {
				for(int k = 0; k < nBlanks; k++){
					System.out.print(" ");
				}
			}
			// display item
			System.out.print(heapArray[j].getKey());
			if (++j == currentSize) {
				break;
			}
			
			if (++currentSize == itemsPerRow) {  // end of row ?
				nBlanks /= 2;		// half the blanks
				itemsPerRow *= 2;		// twice the items
				colum = 0;			// start over on
				System.out.println(""); 		//new row
			} else {			// next item on row
				for(int k = 0; k < nBlanks *2 -2; k++){
					System.out.print("  ");		// insert blanks
				}
			}
		}
		
		System.out.println("\n" + dots + dots);   // dotted bottom line
	}
	

}
