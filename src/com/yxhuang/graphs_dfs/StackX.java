package com.yxhuang.graphs_dfs;

public class StackX {
	private final int SIZE = 20;
	private int[] st;
	private int top;
	
	public StackX(){
		st = new int[SIZE];
		top = -1;
	}
	
	public void push(int i){		// put item on stack
		st[++top] = i;
	}
	
	public int pop(){			// take item off stack
		return st[top--];
	}
	
	public int peek(){			// peek at top of stack
		return st[top];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}

}
