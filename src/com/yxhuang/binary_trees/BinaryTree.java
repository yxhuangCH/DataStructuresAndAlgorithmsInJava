package com.yxhuang.binary_trees;

import java.util.Stack;

/**
 *  Demonstrates binary tree
 * @author Administrator
 *
 */
public class BinaryTree {
	private Node root;			// first node of tree
	
	public BinaryTree(){
		root = null;
	}
	
	/**
	 *  Find node with given key
	 * @param key
	 * @return
	 */
	public Node find(int key){
		Node current = root;
		while(current.iData != key){
			if (key < current.iData) {		// go left ?
				current = current.leftChild;
			} else {
				current = current.rightChild;		// or go right ?
			}
			
			if (current == null) {		// if no child
				return null;
			}
		}
		
		return current;		// found it
	}
	
	public void insert(int id, double dd){
		Node newNode = new Node();		// make new node insert data
		newNode.iData = id;
		newNode.dDate = dd;
		
		if (root == null) {				// no node in root
			root = newNode ;
		} else {
			Node current = root;
			Node parent;
			while(true){
				parent = current;
				if (id < current.iData) {		// go left ?
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				}  else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = null;
						return;
					}
				}
			}
		}
	}
	
	public Node minimum(){
		Node current, last;
		current = root;
		last = root;
		while(current != null){
			last = current;
			current = current.leftChild;   // go to  left child
			// go to right child
//			current = current.rightChild;
		}
		return last;
	}
	
	/**
	 *  Delete node with given key (assume non-empty list)
	 * @param key
	 * @return
	 */
	public boolean delete(int key){
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(current.iData != key){	// search for node
			parent = current;
			if (key < current.iData) {	// go left ?
				isLeftChild = true;
				current = current.leftChild;
			} else {								// or go right ?
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null) {		// end of line, didn't find it
				return false;
			}
		}
		
		// found node to delete
		
		// if no children, simply delete it.
		if (current.leftChild ==null && current.rightChild == null) {
			if (current == root) {			// if root, tree is empty
				root = null;
			} else  if (isLeftChild){
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
			// if no right child , replace with left subtree
		} else if (current.rightChild == null) {
			if (current == root) {
				root = current.leftChild;
			} else if (isLeftChild) {
				parent.leftChild = current.leftChild;
			} else {
				parent.rightChild = current.leftChild;
			}
			// if no left child, replace with right subtree
		} else if (current.leftChild == null) {
			if (current == null) {
				root = current.rightChild;
			} else if (isLeftChild) {
				parent.leftChild = current.rightChild;
			} else {
				parent.rightChild = current.rightChild;
			}
			// two children, so place with inorder successor
		} else {
			// get successor of node to delete(current)
			Node successor = getSuccessor(current);
			
			// connect parent of current to successor instead
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.leftChild = successor;
			} else {
				parent.rightChild = successor;
			}
			// connect successor to current' left  child
			successor.leftChild = current.leftChild;
		}
		
		return true;
	}
	
	private Node getSuccessor(Node delNode){
		Node successorParent = root;
		Node successor =  delNode;
		Node current = delNode.rightChild; 
		while(current != null){
			successorParent  = successor;
			successor = current;
			current = current.leftChild;	// go to left chid
		}
		
		// if successor not right child, make connections
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		
		return successor;
	}
	
	
	public void travarse(int traverseType){
		switch (traverseType) {
		case 1:
			System.out.print("\nPreOrder traversal:  ");
			preOrder(root);
			break;
			
		case 2:
			System.out.print("\nInOrder traversal:  ");
			inOrder(root);
			break;
			
		case 3:
			System.out.print("\nPostOrder traversal:  ");
			postOrder(root);
			break;

		default:
			break;
		}
	}
	
	private void preOrder(Node localRoot){
		if (localRoot != null) {
			System.out.print(localRoot.iData + "  ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	private void inOrder(Node localRoot){
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + "  ");
			inOrder(localRoot.rightChild);
		}
	}
	
	private void postOrder(Node localNode){
		if (localNode != null) {
			postOrder(localNode.leftChild);
			System.out.print(localNode.iData + "  ");
			postOrder(localNode.rightChild);
		}
	}
	
//	public void displayTree(){
//		Stack globalStack = new Stack<E>();
//		globalStack.push(root);
//		int nBlanks = 32;
//		boolean isPowEmpty = false;
//		System.out.println("................................................................................");
//		while(isPowEmpty == false){
//			
//		}
//	}

}
