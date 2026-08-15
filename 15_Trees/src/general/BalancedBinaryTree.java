package general;

import leetcode_treenode_impl.TreeNode;

public class BalancedBinaryTree {
    private static int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        if (left == -1) return -1;
        int right = height(root.right);
        if (right == -1) return -1;

        // check for if current node is unbalanced. then, bubble up -1
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    static void main() {
        System.out.println(isBalanced(TreeNode.of(3,9,20,null,null,15,7))); // true
        System.out.println(isBalanced(TreeNode.of(1,2,2,3,3,null,null,4,4))); // false
        System.out.println(isBalanced(TreeNode.of())); // true
        System.out.println(isBalanced(TreeNode.of(1,2,2,3,null,null,3,4,null,null,4))); // false
    }
}
