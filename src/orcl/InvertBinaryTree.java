package orcl;

import datastructures.basic.trees.TreeNode;

public class InvertBinaryTree {
	
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }

}
