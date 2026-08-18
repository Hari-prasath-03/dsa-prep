package problems.dfs_recursion;

import leetcode_treenode_impl.TreeNode;

public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    static void main() {
        System.out.println(isSameTree(TreeNode.of(1,2,3), TreeNode.of(1,2,3)));
        System.out.println(isSameTree(TreeNode.of(1,2), TreeNode.of(1,null,2)));
        System.out.println(isSameTree(TreeNode.of(1,2,1), TreeNode.of(1,1,2)));
    }
}
