package com.yxhuang.java.stacksAndQueues;

/**
 * Demonstrates queue
 */
public class Queue {
	private int maxSize;
	private long[] queArray;
	private int front;  // 头部
	private int rear;	// 尾部
	private int nItems;
	
	public Queue(int s){
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	
	public void insert(long i){
		if (rear == maxSize -1) {		// deal with wraparound
			rear = -1;
		}
		queArray[++rear] = i;
		nItems++;
	}
	
	public long remove(){
		long temp = queArray[front++];  // get value and incr front
		if (front == maxSize) {			// deal with wraparound
			front = 0;
		}
		nItems--;
		return temp;
	}
	
	public long peekFront(){
		return queArray[front];
	}
	
	public boolean isEmpty(){
		return (nItems == 0);
	}
	
	public boolean isFull(){
		return (nItems == maxSize);
	}
	
	public int size(){
		return nItems;
	}

}
