package problems.bts_properties;

import leetcode_treenode_impl.TreeNode;

public class KthSmallestElementInBST {
    public static int kthSmallest(TreeNode root, int k) {
        return kthSmallest(root, new int[] {k});
    }

    private static int kthSmallest(TreeNode root, int[] k) {
        if (root == null) return -1;

        int left = kthSmallest(root.left, k);
        if (left != -1) return left;

        if (--k[0] == 0) return root.val;

        return kthSmallest(root.right, k);
    }

    static void main() {
        System.out.println(kthSmallest(TreeNode.of(3,1,4,null,2), 1)); // 1
        System.out.println(kthSmallest(TreeNode.of(5,3,6,2,4,null,null,1), 3)); // 3
    }
}
