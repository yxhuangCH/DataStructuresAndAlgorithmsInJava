package com.yxhuang.graphs_bfs;

public class Queue {
	private final int SIZE = 20;
	private int[] quaArray;
	private int front;
	private int rear;
	
	public Queue(){
		quaArray = new int[SIZE];
		front = 0;
		rear = -1;
	}
	
	/**
	 *  Put item at rear of queue
	 * @param j
	 */
	public void insert(int j)	{
		if (rear == SIZE -1) {
			rear = -1;
		}
		quaArray[++rear] = j;
	}
	
	/**
	 *  Take item from front of queue
	 * @return
	 */
	public int remove(){
		int temp = quaArray[front++];
		if (front == SIZE) {
			front = 0;
		}
		return temp;
	}
	
	public boolean isEmpty(){
		return rear + 1 == front || front + SIZE - 1 == rear;
	}
	

}
