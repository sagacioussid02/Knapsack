package datastructures.basic.trees;

import java.util.ArrayList;
import java.util.List;

public class LeafBoundaryTree {
    
    public static List<TreeNode> getLeafBoundary(TreeNode root){
        List<TreeNode> list = new ArrayList<TreeNode>();
        recursionHelper(root, list);
        return list;
    }

    private static void recursionHelper(TreeNode root, List<TreeNode> list) {
        if(root == null) return;
        //inorder traversal
        recursionHelper(root.left,list);
        if(root.left == null && root.right == null) {
            list.add(root);
            return;
        }
        recursionHelper(root.right,list);     
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeOperations op = new TreeOperations();
        op.addNode(root, 3);
        op.addNode(root, 5);
        op.addNode(root, 4);
        op.addNode(root, 6);
        
        getLeafBoundary(root).stream().forEach(treeNode -> System.out.println(treeNode.data));
    }

}
