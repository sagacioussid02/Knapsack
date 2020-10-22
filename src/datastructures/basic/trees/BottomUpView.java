package datastructures.basic.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BottomUpView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeOperations op = new TreeOperations();
        op.addNode(root, 3);
        op.addNode(root, 5);
        op.addNode(root, 4);
        op.addNode(root, 6);
        bottomUpView(root);
    }
    
    public static void bottomUpView(TreeNode root) {

        Queue<HorizontalTreeNodeLevelPair> qu = new LinkedList<HorizontalTreeNodeLevelPair>();
        qu.add(new HorizontalTreeNodeLevelPair(root, 0));

        Map<Integer, LinkedList<TreeNode>> horizontalLevelByNodeList = new HashMap<Integer, LinkedList<TreeNode>>();
        while (!qu.isEmpty()) {
            HorizontalTreeNodeLevelPair pop = qu.poll();
            if (pop.node.left != null) {
                qu.add(new HorizontalTreeNodeLevelPair(pop.node.left, pop.horizontalLevel - 1));
            }
            if (pop.node.right != null)
                qu.add(new HorizontalTreeNodeLevelPair(pop.node.right, pop.horizontalLevel + 1));
            LinkedList<TreeNode> tempList = horizontalLevelByNodeList.getOrDefault(pop.horizontalLevel,
                    new LinkedList<TreeNode>());
            tempList.addFirst(pop.node);
            horizontalLevelByNodeList.put(pop.horizontalLevel, tempList);
        }
        printView(horizontalLevelByNodeList);
    }

    private static void printView(Map<Integer, LinkedList<TreeNode>> horizontalLevelByNodeList) {
        horizontalLevelByNodeList.values().stream().forEach(list -> System.out.println(list.getFirst().data));
    }

}

class HorizontalTreeNodeLevelPair{
    TreeNode node;
    int horizontalLevel;
    
    public HorizontalTreeNodeLevelPair(TreeNode node, int horizontalLevel) {
        this.node = node;
        this.horizontalLevel = horizontalLevel;
    }
}
