package com.yxhuang.graphs_bfs;

/**
 *  Demonstrates breadth-first search
 * @author Administrator
 *
 */
public class Graph {
	
	private final int MAX_VERTS = 20;
	private Vertex vertexList[];	// list of vertices
	private int adjMat[][];			// adjacency matrix
	private int nVerts;				// current number of vertices
	private Queue theQueue;
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		// set adjacency matrix to 0
		for(int i = 0; i < MAX_VERTS; i++){
			for (int j = 0; j < MAX_VERTS; j++) {
				adjMat[i][j] = 0;
			}
		}
		theQueue = new Queue();
	}
	
	public void addVertex(char lab){
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end){
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public void displayVertex(int v){
		System.out.print(vertexList[v].label);
	}
	
	public void bfs(){  // breadth-first search begin at vertex 0
		vertexList[0].wasVisited = true;
		displayVertex(0);
		theQueue.insert(0);
		int v2;
		
		while(!theQueue.isEmpty()){
			int v1 = theQueue.remove();		// remove vertex at head
			// until it has no unvisited neighbors
			while((v2 = getAdjUnvisitedVertex(v1)) != -1){
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				theQueue.insert(v2);
			}
		}
		
		// queue is empty
		for(int i = 0;i < nVerts; i++){
			vertexList[i].wasVisited = false;
		}
	}
	
	public int getAdjUnvisitedVertex(int v){
		for (int i = 0; i < nVerts; i++) {
			if(adjMat[v][i] ==1 && vertexList[i].wasVisited == false){
				return i;
			}
		}
		return -1;
	}

}
