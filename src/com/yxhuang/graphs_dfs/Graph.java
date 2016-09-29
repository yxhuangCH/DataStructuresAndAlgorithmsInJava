package com.yxhuang.graphs_dfs;

/**
 * Demonstrates depth-first search
 * @author Administrator
 *
 */
public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];		// adjacency matrix;
	private int nVerts;			// current number of vertices
	private StackX theStackX;
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		// adjacency matrix
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		
		nVerts = 0;
		for(int i = 0; i < MAX_VERTS; i++){	// set adjacency matrix to 0
			for (int j = 0; j < MAX_VERTS; j++) {
				adjMat[i][j] = 0;
			}
		}
		theStackX = new StackX();
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
	
	// depth-first search
	public void dfs(){
		vertexList[0].wasVisited = true;
		displayVertex(0);
		theStackX.push(0);
		
		while(!theStackX.isEmpty()){
			// get an unvisited vertex adjacent to stack top
			int v = getAdjUnvisitedVertex(theStackX.peek());
			if (v == -1) {		// if no such vertex
				theStackX.pop();  
			} else {				// if it exists
				vertexList[v].wasVisited = true;
				displayVertex(v);
				theStackX.push(v);
			}
		}
		
		// stack it empty, so we're done
		for(int i = 0; i < nVerts; i++){		// reset flags
			vertexList[i].wasVisited = false;
		}
	}
	
	public int getAdjUnvisitedVertex(int v){
		for(int i = 0; i < nVerts; i++){
			if(adjMat[v][i] == 1 && vertexList[i].wasVisited == false){
				return i;
			}
		}
		return -1;
	}

}
