package datastructures.basic.trees;

public class TreeOperations {
    
    public void addNode(TreeNode root, int data) {
        if(root == null) return;
        if(root.data == data) return;
        if(root.data < data) {
            if(root.right == null) root.right = new TreeNode(data);
            else addNode(root.right,data);
        } else if(root.data > data) {
            if(root.left == null) root.left = new TreeNode(data);
            else addNode(root.left,data);
        }
        
    }

}
