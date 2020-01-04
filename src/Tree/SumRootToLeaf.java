package Tree;
import Tree.TreeNode;

public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        //sanity check
        if (root == null) {
            return 0;
        }
        return backTracking(root, 0);
    }

    private int backTracking(TreeNode root, int preSum)  {
        //base case
        if (root.left == null && root.right == null) {
            return preSum * 10 + root.val;
        }
        //update cur path
        preSum = preSum * 10 + root.val;
        //recursion
        int curSum = 0;
        if (root.left != null) {
            curSum += backTracking(root.left, preSum);
        }
        if (root.right != null) {
            curSum += backTracking(root.right, preSum);
        }
        return curSum;
    }

    public static void main(String[] args) {
        SumRootToLeaf ob = new SumRootToLeaf();
        TreeNode root = new TreeNode(7);
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(8);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        ob.sumNumbers(root);
        System.out.println(ob.sumNumbers(root));
    }
}





