package datastructures.basic.trees;

import java.util.ArrayList;
import java.util.List;

public class LeftBoundaryTree {
    
    
    public static List<TreeNode> getLeftBoundary(TreeNode root){
        List<TreeNode> list = new ArrayList<TreeNode>();
        recursionHelper(root, list);
        return list;
    }

    private static void recursionHelper(TreeNode root, List<TreeNode> list) {
        if(root == null) return;
        list.add(root);
        if(root.left == null && root.right == null) return; 
        else if(root.left == null) recursionHelper(root.right, list);
        else recursionHelper(root.left, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeOperations op = new TreeOperations();
        op.addNode(root, 3);
        op.addNode(root, 5);
        op.addNode(root, 4);
        op.addNode(root, 6);
        
        getLeftBoundary(root).stream().forEach(treeNode -> System.out.println(treeNode.data));
    }

}
