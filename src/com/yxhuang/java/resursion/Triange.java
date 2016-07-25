package com.yxhuang.java.resursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Thread.State;

/**
 * @author Administrator
 *	Evaluates triangular numbers
 */
public class Triange {
	static int theNumber;
	
	public static void main(String[] args) throws IOException {
		System.out.print("Enter a number:  ");
		theNumber = getInt();
		int theAnswer = triangle(theNumber);
		System.out.println("Triangle = " + theAnswer);
	}
	
	private static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}
	
	private static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	
	private static int triangle(int n){
		if (n == 1) {
			return 1;
		} else {
			return (n + triangle(n-1));
		}
	}
	
}
