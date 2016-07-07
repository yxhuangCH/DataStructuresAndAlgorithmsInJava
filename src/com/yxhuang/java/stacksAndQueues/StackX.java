package com.yxhuang.java.stacksAndQueues;

/**
 *  Demonstrates stacks
 */
public class StackX {
	private int maxSize;
	private long[] stackArray;
	private int top;
	
	public StackX(int s){
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}
	
	public void push(long i){  // put item on top of stack
		stackArray[++top] = i;
	}
	
	public long pop(){  // take item from top of stack
		return stackArray[top--];    // access item, decrement top
	}
	
	public long peek(){  // peek at top of stack
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){  // true if stack is full
		return (top == maxSize -1);
	}
}
	
