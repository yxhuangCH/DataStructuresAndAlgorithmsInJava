package com.yxhuang.java.stacksAndQueues;

public class StackApp {
	public static void main(String[] args) {
		StackX theStackX = new StackX(10);
		theStackX.push(20);
		theStackX.push(40);
		theStackX.push(60);
		theStackX.push(80);
		
		while (!theStackX.isEmpty()) {
			long value = theStackX.pop();
			System.out.print(value);
			System.out.print("  ");
		}
		
		System.out.println("");
	}

}
