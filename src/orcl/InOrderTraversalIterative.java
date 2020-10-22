package orcl;

import java.util.Stack;

import datastructures.basic.trees.TreeNode;
import datastructures.basic.trees.TreeOperations;

public class InOrderTraversalIterative {
	
	public static void inOrderIterative(TreeNode root) {
		Stack<TreeNode> nodeStack = new Stack<TreeNode>();
		TreeNode temp = root;
		while(temp!=null || nodeStack.size() > 0) {
			while(temp != null) {
				nodeStack.push(temp);
				temp = temp.left;
			}
			temp = nodeStack.pop();
			System.out.println(temp.data);
			temp = temp.right;
		}
	}
	
	public static void inOrderRecursion(TreeNode root) {
		if(root == null) {
			return;
		}
		inOrderRecursion(root.left);
		System.out.println(root.data);
		inOrderRecursion(root.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeOperations op = new TreeOperations();
		op.addNode(root, 3);
		op.addNode(root, 8);

		op.addNode(root, 2);
		op.addNode(root, 4);
		op.addNode(root, 7);
		op.addNode(root, 9);
		
		inOrderIterative(root);

	}

}
