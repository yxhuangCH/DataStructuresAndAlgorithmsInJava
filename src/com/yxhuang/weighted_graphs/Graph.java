package com.yxhuang.weighted_graphs;

/**
 *  Demonstrates minimum spanning tree with weighted graphs 
 * @author Administrator
 *
 */
public class Graph {
	private final int MAX_VERTS = 20;
	private final int INFINITY = 1000000;
	private Vertex vertexList[];		// list of vertex
	private int adjMat[][];
	private int nVerts;
	private int currentVert;
	private PriorityQ thePQ;
	private int nTree;		// the number of verts in tree
	
	public Graph(){
		vertexList = new Vertex[MAX_VERTS];
		
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for(int i = 0; i < MAX_VERTS; i++){
			for(int j = 0; j < MAX_VERTS; j++){
				adjMat[i][j] = INFINITY;
			}
		}
		thePQ = new PriorityQ();
	}
	
	public void addVertex(char lab){
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end, int weight){
		adjMat[start][end] = weight;
		adjMat[end][start] = weight;
	}
	
	public void displayVertex(int v){
		System.out.print(vertexList[v].label);
	}
	
	/**
	 *  Minimum spanning tree
	 */
	public void mstw(){
		currentVert = 0;  	// start at 0
		
		while(nTree < nVerts - 1){
			vertexList[currentVert].isInTree = true;
			nTree++;
			
			// insert edges adjecent to current into PQ
			for(int i = 0; i < nVerts; i++){
				if (i == currentVert) {		// for each vertex
					continue;
				}
				if (vertexList[i].isInTree) {  // skip if it's tree
					continue;
				}
				
				int distance = adjMat[currentVert][i];
				if (distance == INFINITY) {		// skip if no edge
					continue;
				}
				putInPQ(i, distance);		// put it in PQ
			}
			
			if(thePQ.size() == 0){
				System.out.print("GRAPH NOT CONNECTED");
				return;
			}
			// remove edge with minimun distance, from PQ
			Edge theEdge = thePQ.removeMin();
			int sourceVert = theEdge.srcVert;
			currentVert = theEdge.destVert;
			
			// display edge from source to current
			System.out.print(vertexList[sourceVert].label);
			System.out.print(vertexList[currentVert].label);
			System.out.print(" ");
		}
		
		// mst is complete
		for(int i = 0; i < nVerts; i++){
			vertexList[i].isInTree = false;
		}
	}
	
	public void putInPQ(int newVert, int newDist){
		// is there another edge with the same destination vertex?
		int queueIndex = thePQ.find(newDist);
		if (queueIndex != -1) {
			Edge tempEdge = thePQ.peekN(queueIndex);	// get edge
			int oldDist = tempEdge.distance;
			if (oldDist > newDist) {		// if new edge shorter
				thePQ.removeN(queueIndex);
				Edge edge = new Edge(currentVert, newVert, newDist);
				thePQ.insert(edge);
			}
		} else {
			Edge edge = new Edge(currentVert, newVert, newDist);
			thePQ.insert(edge);
		}
	}
}
