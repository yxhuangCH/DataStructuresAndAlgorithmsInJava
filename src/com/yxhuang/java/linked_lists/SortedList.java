package com.yxhuang.java.linked_lists;

public class SortedList {
	private Link first;		// reference to first item on first
	
	public SortedList() {
		first = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	// insert, in order
	public void insert(long key){
		Link newLink = new Link(key);
		Link previous = null;		//start at first
		Link current = first;
		
		while(current != null && key > current.dData){
			previous = current;
			current = current.next;
		}
		
		if (previous == null) {	// at beginning of list
			first = newLink;
		} else {
			previous.next = newLink;
		}
		
		newLink.next = current;
	}
	
	// return & delete first link
	public Link remove(){
		Link temp = first;
		first = first.next;
		return temp;
	}
	
	public void displayList(){
		System.out.print("List (first --> last): ");
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println("");
	}
	
	
	public static void main(String[] args) {
		SortedList theSortedList = new SortedList();
		
		theSortedList.insert(20);
		theSortedList.insert(40);
		
		theSortedList.displayList();
		
		theSortedList.insert(10);
		theSortedList.insert(30);
		theSortedList.insert(50);
		
		theSortedList.displayList();
		
		theSortedList.remove();
		
		theSortedList.displayList();
	}
	
	
	
	class Link{
		public long dData;		// date item
		public Link next;
		
		public Link(long dd){
			dData = dd;
		}
		
		public void displayLink(){
			System.out.print(dData + "  ");
		}
	}

}
