package orcl;

import datastructures.basic.trees.TreeNode;
import datastructures.basic.trees.TreeOperations;

public class PathSum3 {
	
    private static int count = 0;
    public static int pathSum(TreeNode root, int sum) {
        recursionHelper(root,sum,0); 
        return count;
    }
    
    public static void recursionHelper(TreeNode root, int target, int currentSum){
        if(root == null){
            return;
        }
        
        int sumSoFar = currentSum + root.data;
        if(sumSoFar == target){
            count += 1;
        }
        
        recursionHelper(root.left, target, sumSoFar);
        recursionHelper(root.right, target, sumSoFar);      
    }

	public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeOperations op = new TreeOperations();
        op.addNode(root, 3);
        op.addNode(root, 8);
		/*
		 * op.addNode(root, 2); op.addNode(root, 4); op.addNode(root, 7);
		 * op.addNode(root, 9);
		 */
        
        pathSum(root,8);

	}

}
