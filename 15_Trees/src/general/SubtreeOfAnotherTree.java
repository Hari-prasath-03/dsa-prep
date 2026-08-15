package general;

import leetcode_treenode_impl.TreeNode;

public class SubtreeOfAnotherTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    static void main() {
        System.out.println(isSubtree(TreeNode.of(3,4,5,1,2), TreeNode.of(4,1,2)));
        System.out.println(isSubtree(TreeNode.of(3,4,5,1,2,null,null,null,null,0), TreeNode.of(4,1,2)));
    }
}
