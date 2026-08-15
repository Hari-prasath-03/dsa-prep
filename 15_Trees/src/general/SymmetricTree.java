package general;

import leetcode_treenode_impl.TreeNode;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    static boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null || r == null) return l == r;
        if (l.val != r.val) return false;
        return isSymmetric(l.right, r.left) && isSymmetric(l.left, r.right);
    }

    static void main() {
        System.out.println(isSymmetric(TreeNode.of(1,2,2,3,4,4,3)));
        System.out.println(isSymmetric(TreeNode.of(1,2,2,null,3,null,3)));
    }
}
