package datastructures.basic.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LowestCommonAncestor {
    /**
     *          5
     *       3     8
     *    2    4 7   9
     * 
     * Find the path to get the two elements and find the common prefixes
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, int a, int b) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return null;
        List<TreeNode> listA = getPath(root, a, new ArrayList<TreeNode>(),false);
        List<TreeNode> listB = getPath(root, b, new ArrayList<TreeNode>(),false);
        TreeNode lca = null;
        int index = 0;
        while(index < listA.size() && index < listB.size() && !listA.isEmpty() && !listB.isEmpty()) {
            if(listA.get(index).equals(listB.get(index))) lca = listA.get(index);
            else break;
            index++;
        }
        return lca == null? new TreeNode(Integer.MAX_VALUE):lca;
    }
    
    private static List<TreeNode> getPath(TreeNode root, int a, ArrayList<TreeNode> pathList, boolean isFound) {
        //base condition
        if(root == null && !isFound) {
            pathList.clear();
            return pathList;
        } else if(root == null && isFound) return pathList;
        
        if(root.data == a) {
            isFound = true;
            pathList.add(root);
            return pathList;
        }
        
        //action
        pathList.add(root);
        
        //recursion condition
        if(root.data > a) return getPath(root.left,a, pathList,isFound);
        else if(root.data < a) return getPath(root.right,a, pathList, isFound);

        
        return pathList;
    }
    
    public static TreeNode lcaRecursion(TreeNode root, int a, int b) {
        if(root == null) return root;
        
        if(root.data == a || root.data == b) return root;
        
        TreeNode left = lcaRecursion(root.left,a,b);
        TreeNode right = lcaRecursion(root.right,a,b);
        
        if(left !=  null && right != null) return root;
        if(left != null) return left;
        else if(right != null) return right;
        else return null;
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
        
        System.out.println(lowestCommonAncestor(root, 2, 6).data);
        System.out.println(lcaRecursion(root, 2, 7).data);
    }

}
