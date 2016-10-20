package com.yxhuang.weighted_graphs;

public class MSTWApp {
	
	public static void main(String[] args) {
		Graph thegGraph = new Graph();
		thegGraph.addVertex('A'); 		// 0
		thegGraph.addVertex('B'); 		// 1
		thegGraph.addVertex('C'); 		// 2
		thegGraph.addVertex('D'); 		// 3
		thegGraph.addVertex('E'); 		// 4
		thegGraph.addVertex('F'); 		// 5
		
		thegGraph.addEdge(0, 1, 6);		// AB 6
		thegGraph.addEdge(1, 2, 10);	// BC 10
		thegGraph.addEdge(1, 3, 7);		// BD 7
		thegGraph.addEdge(1, 4, 7);		// BE 7
		thegGraph.addEdge(2, 3, 8);		// CD 8
		thegGraph.addEdge(2, 4, 5);		// CE 5
		thegGraph.addEdge(3, 4, 12);	// DE 12
		thegGraph.addEdge(4, 5, 7);		// EF 7
		
		System.out.println("Minimum spanning tree: " );
		thegGraph.mstw();
		System.out.println();
		
	}

}
