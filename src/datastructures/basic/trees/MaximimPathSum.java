package datastructures.basic.trees;

/**
 *          5
 *       3     8
 *    2    4 7   9
 * 
 * Find the max sum path. There could be negative numbers too.
 */
public class MaximimPathSum {
    static int maxSum = Integer.MIN_VALUE;
    
    public static int getMaxPathSum(TreeNode root) {
        //base condition
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.data;
        
        //recursion
        int leftSum = getMaxPathSum(root.left);
        int rightSum = getMaxPathSum(root.right);
        
        //max of wither from left part or right part or the current value
        int maxFromLeftAndRightPath = Math.max(Math.max(leftSum, rightSum) + root.data, root.data);
        
        //max when adding all the paths are giving the max value when the ancestors does not have max
        //this one to update the max sum
        int maxCombiningLeftAndRight = Math.max((leftSum + rightSum + root.data), maxFromLeftAndRightPath);
        
        maxSum = Math.max(maxSum, maxCombiningLeftAndRight);
        
        return maxFromLeftAndRightPath;
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
        
        getMaxPathSum(root);
        System.out.println(maxSum);
    }

}
