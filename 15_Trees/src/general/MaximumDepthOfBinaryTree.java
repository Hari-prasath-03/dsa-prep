package general;

import leetcode_treenode_impl.TreeNode;

public class MaximumDepthOfBinaryTree {
    private static int maxDepth(TreeNode root, int depth) {
        if (root == null) return depth;
        return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
    }

    public static int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    static void main() {
        System.out.println(maxDepth(TreeNode.of(3,9,20,null,null,15,7))); // 3
        System.out.println(maxDepth(TreeNode.of(1,null,2))); // 2
        System.out.println(maxDepth(TreeNode.of(25,20,36,10,22,30,40,5,12,null,null,28,null,38,48,0,6))); // 5
    }
}
