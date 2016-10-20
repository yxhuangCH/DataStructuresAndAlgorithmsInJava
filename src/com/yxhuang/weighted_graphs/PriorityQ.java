package com.yxhuang.weighted_graphs;

import java.awt.geom.QuadCurve2D;

public class PriorityQ {
	// array in sorted order, from max at 0 to min at size-1;
	private final int SIZE = 20;
	private Edge[] queArray;
	private int size;
	
	public PriorityQ(){
		queArray = new Edge[SIZE];
		size = 0;
	}
	
	public void insert(Edge item){
		int j;
		
		for(j = 0; j < size; j++){		// find place to insert
			if(item.distance >= queArray[j].distance){
				break;
			}
		}
		
		// move items up
		for(int k = size -1; k >= j; k--){
			queArray[k+1] = queArray[k];
		}
		
		// insert item
		queArray[j] = item;
		size++;
	}
	
	/**
	 *   Remove minimum item
	 * @return Edge
	 */
	public Edge removeMin(){
		return queArray[--size];
	}
	
	/**
	 * Remove item at n
	 * @param n
	 */
	public void removeN(int n){
		for(int i = n; i < size - 1; i++){
			queArray[i] = queArray[i + 1];
		}
		size--;
	}
	
	/**
	 *  Peek at minimum item
	 * @return
	 */
	public Edge peekMin(){
		return queArray[size - 1];
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 *  Peek at item n
	 * @param n
	 * @return
	 */
	public Edge peekN(int n){
		return queArray[n];
	}
	
	/**
	 *  Find item with specified destVert value
	 * @param findDex
	 * @return
	 */
	public int find(int findDex){
		for(int i = 0; i < size; i++){
			if(queArray[i].destVert == findDex){
				return i;
			}
		}
		return -1;
	}
}
