package problems.bts_properties;

import leetcode_treenode_impl.TreeNode;

public class ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (min >= root.val || max <= root.val) return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

    static void main() {
        System.out.println(isValidBST(TreeNode.of(2,1,3)));
        System.out.println(isValidBST(TreeNode.of(5,1,4,null,null,3,6)));
        System.out.println(isValidBST(TreeNode.of(25,20,36,10,22,30,40,5,12,null,null,28,null,38,48,0,6)));
    }
}
