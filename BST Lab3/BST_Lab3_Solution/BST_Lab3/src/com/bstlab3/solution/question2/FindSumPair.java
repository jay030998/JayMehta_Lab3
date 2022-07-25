package com.bstlab3.solution.question2;

import java.util.HashSet;

public class FindSumPair {

	static class Node{
		int nodeData;
		Node leftNode, rightNode;
	}
	
	static Node NewNode(int nodeData){
		Node temp = new Node();
		temp.nodeData=nodeData;
		temp.leftNode=null;
		temp.rightNode=null;
		
		return temp;
	}
	
	public Node insert(Node root, int key) {
		if(root==null) {
			return NewNode(key);
		}
		if(key < root.nodeData)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);
		return root;
	}
	
	public boolean findPair(Node root, int sum, HashSet<Integer> set) {
		if(root==null)
			return false;
		if(findPair(root.leftNode, sum, set))
			return true;
		if(set.contains(sum-root.nodeData)) {
			System.out.println("Pair is found (" + (sum-root.nodeData) + ", " + root.nodeData + ")");
			return true;
		}
		else
			set.add(root.nodeData);
		
		return findPair(root.rightNode, sum, set);
	}
	
	public void findPairWithGivenSum(Node root,int sum) {
		HashSet<Integer> set =new HashSet<Integer>();
		if(!findPair(root, sum, set))
			System.out.println("Pair does not exist");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = null;
		
		FindSumPair sum = new FindSumPair();
		root = sum.insert(root,40);
		root = sum.insert(root,20);
		root = sum.insert(root,60);
		root = sum.insert(root,10);
		root = sum.insert(root,30);
		root = sum.insert(root,50);
		root = sum.insert(root,70);
		
		int finalSum=130;
		sum.findPairWithGivenSum(root, finalSum);
	}

}
