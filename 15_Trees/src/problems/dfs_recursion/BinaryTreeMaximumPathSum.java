package problems.dfs_recursion;

import leetcode_treenode_impl.TreeNode;

public class BinaryTreeMaximumPathSum {
    public static int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }

    private static int maxPathSum(TreeNode root, int[] max) {
        if (root == null) return 0;
        int left = Math.max(0, maxPathSum(root.left, max));
        int right = Math.max(0, maxPathSum(root.right, max));
        max[0] = Math.max(max[0], left + right + root.val);
        return root.val + Math.max(left, right);
    }

    static void main() {
        System.out.println(maxPathSum(TreeNode.of(1,2,3))); // 6
        System.out.println(maxPathSum(TreeNode.of(-10,9,20,null,null,15,7))); // 42
        System.out.println(maxPathSum(TreeNode.of(25,20,36,10,22,30,40,5,12,null,null,28,null,38,48,0,6))); // 191
    }
}
