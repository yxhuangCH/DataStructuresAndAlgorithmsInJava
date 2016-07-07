package com.yxhuang.java.linked_lists;

/**
 *  Demonstrates linked list
 * @author Administrator
 *
 */
public class LinkList {
	private Link first;
	
	public LinkList(){
		first = null;
	}
	
	public boolean isEmpty(){
		return first == null;
	}

	public void inserFirst(int id, double dd){
		Link newLink = new Link(id, dd);
		newLink.next = first;		// newLink --> 
		first = newLink;				// first --> newLink
	}
	
	public Link deleteFirst(){
		Link temp = first;		// save reference to link
		first = first.next;		// delete it : first --> old next
		return temp;				// return deleted link
	}
	
	public void  displayList(){
		System.out.print("List (first --> last)");
		Link current = first;
		while(current != null){
			current.displayLink();
			current = current.next;
		}
		System.out.println("  ");
	}
	
	public Link find(int key){
		Link current = first;					// start at first
		while(current.iDate != key){  		// while no match
			if (current.next == null) {		// if end of list, didn't find it
				return null;
			} else {
				current = current.next;		// go to next link
			}
		}
		return current;	// found it
	}
	
	public Link delete(int key){
		Link current = first;
		Link previous = first;
		while(current.iDate != key){
			if (current.next == null) {
				return null;
			} else {
				previous = current;
				current = current.next;
			}
		}
		if (current == first) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
		return current;
	}
	
	//**************************************************
	
	public static void main(String[] args) {
		LinkList theList = new LinkList();
		
		theList.inserFirst(22, 2.99);
		theList.inserFirst(44, 4.99);
		theList.inserFirst(66, 6.99);
		theList.inserFirst(88, 8.99);

		theList.displayList();
		
		theList.find(44);
		
		theList.displayList();
		
		theList.delete(66);
//		while(!theList.isEmpty()){
//			Link aLink = theList.deleteFirst();
//			System.out.print("Deleted ");
//			aLink.displayLink();
//			System.out.println(" ");
//		}
		
		theList.displayList();
	}
	
	//******************************************************************************
	
	class Link{
		public int iDate;		// data item (key)
		public double dDate;		// data item
		public Link next;			// next link in list
		
		public Link(int id, double dd){
			iDate = id;
			dDate = dd;  		// next  is automatically set to null
		}
		
		public void displayLink(){
			System.out.print("{" + iDate + ", " + dDate + "}");
		}
	}
	//*************************************************************
}
