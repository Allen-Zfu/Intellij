package com.Tree;
import com.HelperFunction.TreeNode;

public class LongestPath {
    public static void main(String[] args) {
        LongestPath sol = new LongestPath();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root.left = node2;
        System.out.println(sol.findLongestPath(root));
    }
    public int findLongestPath (TreeNode root) {
        return root.key;
    }
}
