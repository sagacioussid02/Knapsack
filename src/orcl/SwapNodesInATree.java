package orcl;

import java.util.ArrayList;
import java.util.List;

import datastructures.basic.trees.TreeNode;
import datastructures.basic.trees.TreeOperations;

/**
 * Two of the nodes of a Binary Search Tree (BST) are swapped. Fix (or correct)
 * the BST.
 * 
 * @author SS057631
 *
 */
public class SwapNodesInATree {
	
	public static TreeNode correctTree(TreeNode swappedNodesTree) {
		//do inorder traversal and store in an array
		List<Integer> inOrderList = new ArrayList<Integer>();
		inOrderTraversal(swappedNodesTree,inOrderList);
		//construct a tree using the inorder traversed array
		TreeNode resultNode = new TreeNode(inOrderList.remove(0));
		TreeOperations op = new TreeOperations();
		while(inOrderList.size() > 0) {
			op.addNode(resultNode, inOrderList.remove(0));
		}
		return resultNode;
	}
	
	public static void inOrderTraversal(TreeNode root, List<Integer> result) {
		if(root==null) {
			return;
		}
		inOrderTraversal(root.left,result);
		result.add(root.data);
		inOrderTraversal(root.right, result);
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
		
		correctTree(root);
	}

}
