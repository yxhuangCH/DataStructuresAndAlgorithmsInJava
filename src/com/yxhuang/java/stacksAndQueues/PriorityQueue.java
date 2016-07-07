package com.yxhuang.java.stacksAndQueues;

/**
 *  Demonstrates priority queue
 */
public class PriorityQueue {
	private int maxSize;
	private long[] queueArray;
	private int nItems;
	
	public PriorityQueue(int s){
		maxSize = s;
		queueArray = new long[maxSize];
		nItems = 0;
	}
	
	public void insert(long item){
		int i;
		if (nItems == 0) { 								// if no items
			queueArray[nItems++] = item;		// insert at 0
		} else {
			for (i = nItems -1; i >= 0; i--) {
				if (item > queueArray[i]) {		// if new item larger
					queueArray[i + 1] = queueArray[i];	// shift upward
				} else {
					break;
				}
			}
			
			queueArray[i + 1] = item;       // insert it
			nItems++;
		}
	}
	
	public long remove(){						// remove minimum item
		return	queueArray[--nItems];
	}
	
	public long peekMin(){
		return queueArray[nItems - 1];
	}
	
	public boolean isEmpty(){
		return (nItems == 0);
	}
	
	public boolean isFull(){
		return (nItems == maxSize);
	}

}
