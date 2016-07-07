package com.yxhuang.java.linked_lists;


/**
 *  Demonstrates doubly - linked list
 */
public class DoublyLinkedList {
	
	public static void main(String[] args) {
		DoublyLinkedList theList = new DoublyLinkedList();
		
		theList.insertFirst(22);
		theList.insertFirst(44);
		theList.insertFirst(66);
		
		theList.insertLast(11);
		theList.insertLast(33);
		theList.insertLast(55);
		
		theList.displayForword();
		theList.displayBackward();
		
		theList.deleteFirst();
		theList.deleteLast();
		theList.deleteKey(11);
		
		theList.displayForword();
		
		theList.insertAfter(22, 77);
		theList.insertAfter(33, 88);
		
		theList.displayForword();
	}
	
	
	
	
//	class DoublyLinkedList{
		private Link first;			// reference to first item
		private Link last;			// reference to last item
		
		public DoublyLinkedList(){
			first = null;
			last = null;
		}
		
		public boolean isEmpty(){
			return first == null;
		}
		
		// insert at front of list
		public void insertFirst(long dd){
			Link newLink = new Link(dd);
			
			if (isEmpty()) {
				last = newLink;
			} else {
				first.previous = newLink;
			}
			
			newLink.next = first;
			first = newLink;
		}
		
		// insert at end of list
		public void insertLast(long dd){
			Link newLink = new Link(dd);
			if (isEmpty()) {
				first = newLink;
			} else {
				last.next = newLink;
				newLink.previous = last;
			}
			last = newLink;
		}
		
		// delete first link
		public Link deleteFirst(){
			Link temp = first;
			if (first.next == null) {		// if only one item
				last = null;
			} else {
				first.next.previous = null;
			}
			
			first = first.next;
			return temp;
		}
		
		// delete last link
		public Link deleteLast(){
			Link temp = last;
			if (first.next ==null) {	// if only one item
				first = null;
			} else {
				last.previous.next = null;
			}
			
			last = last.previous;
			return temp;
		}
		
		// insert dd just after key
		public boolean insertAfter(long key, long dd){
			Link current = first;
			while(current.dData != key){
				current = current.next;
				if (current == null) {
					return false;      // didn't find it
				}
			}
			
			Link newLink = new Link(dd);
			
			if (current == last) {		// if last link
				newLink.next = null;
				last = newLink;
			} else {
				newLink.next = current.next;
				current.next.previous = newLink;
			}
			newLink.previous = current;
			current.next = newLink;
			return true;
		}
		
		//	delete item given key
		public Link deleteKey(long key){
			Link current = first;
			while(current.dData != key){
				current = current.next;
				if (current == null) {
					return null;		// didn't find it
				}
			}
			
			if (current == first) {
				first = current.next;
			} else {
				current.previous.next = current.next;
			}
			
			if (current == last) {
				last = current.previous;
			} else {
				current.next.previous = current.previous;
			}
			
			return current;
		}
		
		public void displayForword(){
			System.out.print("Last (first --> last): ");
			Link current = first;
			while(current != null){
				current.displayLink();
				current = current.next;
			}
			
			System.out.println("");
		}
		
		public void displayBackward(){
			System.out.println("List (last -- > first): ");
			Link current = last;
			while(current != null){
				current.displayLink();
				current = current.previous;
			}
			System.out.println("");
		}
//	}
	
	class Link{
		public long dData;		// data item
		public Link next;
		public Link previous;
		
		public Link(long dd){
			dData = dd;
		}
		
		public void displayLink(){
			System.out.print(dData +"  ");
		}
	}

}
