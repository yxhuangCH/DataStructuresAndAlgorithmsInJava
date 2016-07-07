package com.yxhuang.java.linked_lists;

/**
 *  Demostrates list with first and last references(Double-Ended Lists)
 * @author Administrator
 *
 */
public class FirstLastList {
	private Link first;		// reference to first link
	private Link last; 		// reference to last link
	
	public FirstLastList(){
		first = null;
		last = null;
	}
	
	public boolean isEmty(){
		return first == null;
	}
	
	// insert at front of list
	public void insertFirst(long dd){		
		Link newLink = new Link(dd);
		if (isEmty()) {
			last = newLink;		
		}
		
		newLink.next = first;
		first = newLink;
	}
	
	//	insert at end of list
	public void insertLast(long dd){
		Link newLink = new Link(dd);
		if (isEmty()) {
			first = newLink;
		} else {
			last.next = newLink;
		}
		
		last = newLink;
	}
	
	//	delete first link
	public long deleteFirst(){
		long temp = first.dData;
		if (first.next == null) {	// if only one item
			last = null;
		}
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
		System.out.println(" ");
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		FirstLastList theList = new FirstLastList();
		
		theList.insertFirst(22);
		theList.insertFirst(44);
		theList.insertFirst(66);
		
		theList.insertLast(11); 
		theList.insertLast(33);
		theList.insertLast(55);
		
		theList.displayList();
		
		theList.deleteFirst();
		theList.deleteFirst();
		
		theList.displayList();
	}

	
	class Link{
		public long dData;		// date item
		public Link next;			// next link in list
		
		public Link(long d){
			dData = d;
		}
		
		// display this link
		public void displayLink(){
			System.out.print(dData + "  ");
		}
	}

}
