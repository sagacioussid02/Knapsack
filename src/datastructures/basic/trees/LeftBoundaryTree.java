package datastructures.basic.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftBoundaryTree {
    
    //this approach is recursive approach
    public static List<TreeNode> getLeftBoundary(TreeNode root){
        List<TreeNode> list = new ArrayList<TreeNode>();
        recursionHelper(root, list, 0);
        return list;
    }

    private static void recursionHelper(TreeNode root, List<TreeNode> list, int horizontalLevel) {
        //if the current level is same as the number of elements in the list
        //for that level then its the leftmost. Since we always start recursion from the leftmost
        //node on that level which will give us idea which one to add. That means we always have the
        //leftmost one comes first in any level which helps us in checking it with the current
        //horizontal level
        if(horizontalLevel == list.size()) list.add(root);
        
        if(root.left != null) recursionHelper(root.left, list, horizontalLevel + 1);
        if(root.right != null) recursionHelper(root.right, list, horizontalLevel + 1);
        
    }
    
    //this approach is iterative approach using bfs
    public static List<TreeNode> getLeftBoundaryIterative(TreeNode root){
        if(root == null) return Collections.emptyList();
        
        List<TreeNode> leftNodeList = new ArrayList<TreeNode>();
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root);
        
        while(!qu.isEmpty()) {
            int size = qu.size();
            while(size != 0) {
                TreeNode pop = qu.poll();
                if(pop.right != null) qu.add(pop.right);
                if(pop.left != null) qu.add(pop.left);
                //add it to the list as last element is always the leftmost
                if(size == 1) leftNodeList.add(pop);
                size--;
            }
        }
        return leftNodeList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeOperations op = new TreeOperations();
        op.addNode(root, 3);
        op.addNode(root, 5);
        op.addNode(root, 4);
        op.addNode(root, 6);
        
        getLeftBoundary(root).stream().forEach(treeNode -> System.out.println(treeNode.data));
        System.out.println("\n");
        getLeftBoundaryIterative(root).stream().forEach(treeNode -> System.out.println(treeNode.data));
    }

}
