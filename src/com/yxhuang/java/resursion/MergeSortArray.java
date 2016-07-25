package com.yxhuang.java.resursion;

public class MergeSortArray {
	private long[] theArray;
	private int nElems;
	
	public MergeSortArray(int max){
		theArray = new long[max];
		nElems = 0;
	}
	
	public void intsert(long value){
		theArray[nElems] = value;
		nElems++;
	}
	
	public void display(){
		for(int i = 0; i < nElems; i++){
			System.out.print(theArray[i] + " ");
		}
		System.out.println("");
	}
	
	public void mergeSort(){
		long[] workSpace = new long[nElems];
		recMergeSort(workSpace, 0, nElems - 1);
	}
	
	private void recMergeSort(long[] workSpaces, int lowerBound, int upperBound){
		if (lowerBound == upperBound) {		// if range is 1,
			return;			// no use sorting
		} else {
			int mid = (lowerBound + upperBound) / 2;		// find midpoint
			recMergeSort(workSpaces, lowerBound, mid);	// sort low half
			recMergeSort(workSpaces, mid + 1, upperBound);	// sort hight half
			merge(workSpaces, lowerBound, mid + 1, upperBound);
		}
	}
	
	private void merge(long[] workSpace, int lowPtr, int hightPtr, int upperBound){
		int j = 0;		// workspace index
		int lowerBound = lowPtr;
		int mid = hightPtr - 1;
		int n = upperBound - lowerBound + 1;		// # of items
		
		while(lowPtr <= mid && hightPtr <= upperBound){
			if (theArray[lowPtr] < theArray[hightPtr]) {
				workSpace[j++] = theArray[lowPtr++];
			} else {
				workSpace[j++] = theArray[hightPtr++];
			}
		}
		
		while(lowPtr <= mid){
			workSpace[j++] = theArray[lowPtr++];
		}
		
		while(hightPtr <= upperBound){
			workSpace[j++] = theArray[hightPtr++];
		}
		
		for(j = 0; j < n; j++){
			theArray[lowerBound+j] = workSpace[j];
		}
	}

}
